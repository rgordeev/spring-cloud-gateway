package ru.rgordeev.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Author {
    @JsonIgnore
    private String id = UUID.randomUUID().toString();
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
