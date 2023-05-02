package ru.rgordeev.bookstore.controller;

import ru.rgordeev.bookstore.model.Book;
import ru.rgordeev.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.listBooks());
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        final Optional<Book> book = bookService.findBookByIsbn(isbn);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book()));
    }
}
