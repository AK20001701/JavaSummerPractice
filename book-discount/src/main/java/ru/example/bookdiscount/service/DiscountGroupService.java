package ru.example.bookdiscount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.bookdiscount.entity.DiscountGroup;
import ru.example.bookdiscount.repository.DiscountGroupRepository;

import java.util.List;

@Service
public class DiscountGroupService {

    private final DiscountGroupRepository discountGroupRepository;

    @Autowired
    public DiscountGroupService(DiscountGroupRepository discountGroupRepository) {
        this.discountGroupRepository = discountGroupRepository;
    }

    public List<DiscountGroup> getGroups(){
        return discountGroupRepository.findAll();
    }

    public ResponseEntity<Integer> getDiscountByGroupId(Long id) {
        return new ResponseEntity<>(discountGroupRepository.getById(id).getDiscount(), HttpStatus.OK);
    }
}
