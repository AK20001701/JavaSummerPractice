package ru.example.bookstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.entity.Comment;
import ru.example.bookstore.service.BookService;
import ru.example.bookstore.service.CommentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@Slf4j
public class BookController {
    private final BookService bookService;
    private final CommentService commentService;

    public BookController(BookService bookService, CommentService commentService) {
        this.bookService = bookService;
        this.commentService = commentService;
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        log.info("User requested book with id: {} ", id);
        try {
            Book book = bookService.getBookById(id);
            return bookService.getBookById(id);
        } catch (EntityNotFoundException e){
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping("/book/{id}/comment")
    public List<Comment> getBookComments(@PathVariable Long id) {
        log.info("User requested book comments for book with id: {} ", id);
        return commentService.getBookComments(id);
    }
}
