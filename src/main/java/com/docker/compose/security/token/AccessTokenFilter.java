package com.docker.compose.security.token;

import com.docker.compose.security.jwt.JwtHelper;
import com.docker.compose.user.persistance.entity.User;
import com.docker.compose.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AccessTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {


            Optional<String> accessToken = parseAccessToken(request);
            if (accessToken.isPresent() && jwtHelper.validateAccessToken(accessToken.get())) {
                String userId = jwtHelper.getUserIdFromAccessToken(accessToken.get());
                User user = userService.getUserById(userId);
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken
                        (user, null, user.getAuthorities());
            }
        } catch (Exception e) {
            logger.error("Cannot set authentication", e);
        }
        filterChain.doFilter(request, response);
    }

    private Optional<String> parseAccessToken(HttpServletRequest request){
        String autHeader = request.getHeader("Authorization");
        if(StringUtils.hasText(autHeader) && autHeader.startsWith("Bearer ")){
            return Optional.of(autHeader.replace("Brarer ", ""));
        }
        return Optional.empty();
    }
}
