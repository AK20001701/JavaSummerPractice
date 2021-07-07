package ru.example.bookdiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.bookdiscount.entity.DiscountGroup;

public interface DiscountGroupRepository extends JpaRepository<DiscountGroup, Long> {
}
