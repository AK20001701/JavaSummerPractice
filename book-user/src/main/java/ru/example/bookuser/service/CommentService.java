package ru.example.bookuser.service;

import org.springframework.stereotype.Service;
import ru.example.bookuser.entity.Comment;
import ru.example.bookuser.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsForBookWithId(Long id){
        return commentRepository.findCommentByBookId(id);
    }

    public void addNewComment(Comment comment, String name){
        Long currentUserId = userService.getUserIdByNickName(name);
        comment.setAuthorId(currentUserId);
        commentRepository.save(comment);
    }
}
