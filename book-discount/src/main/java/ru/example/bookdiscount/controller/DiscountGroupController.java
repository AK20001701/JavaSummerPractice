package ru.example.bookdiscount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookdiscount.entity.DiscountGroup;
import ru.example.bookdiscount.service.DiscountGroupService;

import java.util.List;

@RestController
public class DiscountGroupController {

    private final DiscountGroupService discountGroupService;

    @Autowired
    public DiscountGroupController(DiscountGroupService discountGroupService) {
        this.discountGroupService = discountGroupService;
    }

    @GetMapping("/discount-group")
    public List<DiscountGroup> getDiscount() {
        return discountGroupService.getGroups();
    }

    @GetMapping("/discount-group/{id}")
    public ResponseEntity<Integer> getDiscount(@PathVariable Long id) {
        return discountGroupService.getDiscountByGroupId(id);
    }
}
