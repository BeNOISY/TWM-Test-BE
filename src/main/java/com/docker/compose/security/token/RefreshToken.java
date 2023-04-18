package com.docker.compose.security.token;

import com.docker.compose.user.persistance.entity.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class RefreshToken {
    @Id
    private String id;

    @Reference
    private User owner;
}
