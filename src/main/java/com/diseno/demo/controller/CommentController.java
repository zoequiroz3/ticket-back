package com.diseno.demo.controller;

import com.diseno.demo.dto.request.CommentDTO;
import com.diseno.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
    }

    @GetMapping
    public void getAllComments() {
        commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public void getCommentDTOById(@PathVariable Long id) {
        commentService.getCommentDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
    }
}
