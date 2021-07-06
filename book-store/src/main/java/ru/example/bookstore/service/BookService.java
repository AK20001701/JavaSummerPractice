package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public BookService(BookRepository bookRepository, DiscountService discountService) {
        this.bookRepository = bookRepository;
        this.discountService = discountService;
    }

    public List<Book> getBooks() {
        Integer discount = discountService.getDiscount();

        return bookRepository.findAll().stream().peek(book -> book.setPrice(book.getPrice().subtract(
                book.getPrice().multiply(new BigDecimal(discount)).divide(new BigDecimal(100),
                       RoundingMode.DOWN))))
                .collect(Collectors.toList());
    }
}
