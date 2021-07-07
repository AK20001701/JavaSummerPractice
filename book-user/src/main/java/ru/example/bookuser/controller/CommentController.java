package ru.example.bookuser.controller;

import org.springframework.web.bind.annotation.*;
import ru.example.bookuser.entity.Comment;
import ru.example.bookuser.service.CommentService;
import ru.example.bookuser.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/book/{id}/comment")
    public List<Comment> getCommentsForBookWithId (@PathVariable Long id){
        return commentService.getCommentsForBookWithId(id);
    }

    @GetMapping("/book/comments")
    public List<Comment> getAllComments (){
        return commentService.getAllComments();
    }

    @PostMapping("/book/comment/add")
    public void add (@RequestBody Comment comment, Principal principal){
        commentService.addNewComment(comment, principal.getName());
    }

}
