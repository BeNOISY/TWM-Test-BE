package com.docker.compose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.docker.compose.Book;
import com.docker.compose.BookRepository;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookRepository.findBooksByGenre(genre);
    }
}