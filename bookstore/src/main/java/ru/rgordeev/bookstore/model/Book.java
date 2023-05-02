package ru.rgordeev.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    @JsonIgnore
    private String id = UUID.randomUUID().toString();
    private String title;
    private String isbn;
    private List<Author> authors;

    public Book(String title, String isbn, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }
}
