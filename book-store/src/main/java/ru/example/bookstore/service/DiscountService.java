package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class DiscountService {

    @Value("${discount.service.by.id}")
    private String getDiscountByIdUrl;

    public Integer getDiscountById(Long id) {
        if (id == 0){
            return 0;
        }
        try {
            ResponseEntity<Integer> responseEntity = new RestTemplate().getForEntity
                    (getDiscountByIdUrl + id, Integer.class);
            return responseEntity.getBody();
        } catch (Exception e){
            log.info("Discount service exception caused by: {}",  e.getClass().getName());
            return 0;
        }
    }
}
