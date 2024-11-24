package com.diseno.demo.controller;

import com.diseno.demo.dto.request.CommentDTO;
import com.diseno.demo.dto.response.GetCommentDTO;
import com.diseno.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<GetCommentDTO>> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCommentDTO> getCommentDTOById(@PathVariable Long id) {
        return commentService.getCommentDTOById(id);
    }

    @PatchMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
    }
}
