package com.docker.compose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docker.compose.Book;
import com.docker.compose.BookRepository;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    @PostMapping("/books")
    public ResponseEntity< Book > createProduct(@RequestBody Book book) {
        return ResponseEntity.ok().body(this.bookRepository.save(book));
    }

    @DeleteMapping("/products")
    public HttpStatus deleteCollection() {
        this.bookRepository.deleteAll();
        return HttpStatus.OK;
    }
}