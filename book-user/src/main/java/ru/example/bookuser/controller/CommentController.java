package ru.example.bookuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookuser.entity.User;
import ru.example.bookuser.repository.UserRepository;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    List<User> getInt() {
        return userRepository.findAll();
    }

}
