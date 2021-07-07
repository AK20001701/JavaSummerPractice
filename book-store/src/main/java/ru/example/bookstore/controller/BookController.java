package ru.example.bookstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.entity.Comment;
import ru.example.bookstore.service.BookService;

import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        log.info("User requested book with id: {} ", id);
        return bookService.getBookById(id);
    }

    @GetMapping("/book/{id}/comments")
    public Set<Comment> getBookComments(@PathVariable Long id) {
        log.info("User requested book comments for book with id: {} ", id);
        return bookService.getBookComments(id);
    }
}
