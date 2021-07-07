package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.example.bookstore.entity.Book;
import ru.example.bookstore.repository.BookRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    public BookService(BookRepository bookRepository, DiscountService discountService) {
        this.bookRepository = bookRepository;
        this.discountService = discountService;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll().stream().peek(this::setBookPriceWithDiscount).collect(Collectors.toList());
    }

    public Book getBookById(long id) {
        Book book = bookRepository.getById(id);
        setBookPriceWithDiscount(book);
        return book;
    }

    public void setBookPriceWithDiscount(Book book) {
        book.setPrice(book.getPrice().subtract(
                book.getPrice().multiply(new BigDecimal(discountService.getDiscountById(book.getDiscountGroupId()))).divide(new BigDecimal(100),
                        RoundingMode.DOWN)));
    }
}
