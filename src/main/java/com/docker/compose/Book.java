package com.docker.compose;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    @Id
    private String id;

    private String bookName;

    private String author;

    private String genre;

    // constructors, getters, and setters omitted for brevity
}