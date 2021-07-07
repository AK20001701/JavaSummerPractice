package ru.example.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.example.bookstore.entity.Comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CommentService {

    @Value("${comment.service}")
    private String commentUrl;

    public List<Comment> getBookComments(Long id){
        try {
            ResponseEntity<Comment[]> response =
                    new RestTemplate().getForEntity(
                            commentUrl + id + "/comment",
                    Comment[].class);
            return Arrays.asList(response.getBody());

        } catch (Exception e){
            log.info("User service exception caused by: {}",  e.getClass().getName());
            return new ArrayList<>();
        }
    }

}
