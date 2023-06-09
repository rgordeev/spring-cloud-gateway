package ru.rgordeev.bookstore.service;

import ru.rgordeev.bookstore.model.Author;
import ru.rgordeev.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
        books.add(new Book("Becoming", "9781524763138", Arrays.asList(new Author("Michelle Obama"))));
        books.add(new Book("Liar Liar", "9780316418249",  Arrays.asList(new Author("James Patterson"), new Author("Candice Fox"))));
        books.add(new Book("The Chef", "9780316453301", Arrays.asList(new Author("Max DiLallo "), new Author("James Patterson"))));
        books.add(new Book("Stranger Things - Suspicious Minds", "9781984800886", Arrays.asList(new Author("Gwenda Bond"))));
    }

    public List<Book> listBooks(){
        return this.books;
    }

    public Optional<Book> findBookByIsbn(String isbn){
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
    }

    public void addBook(Book book){
        books.add(book);
    }

}
