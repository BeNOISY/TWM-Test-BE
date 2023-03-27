package com.docker.compose;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docker.compose.Book;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{ 'genre' : $genre }")
    List<Book> findBooksByGenre(String genre);
}
