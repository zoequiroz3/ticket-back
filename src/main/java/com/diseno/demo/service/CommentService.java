package com.diseno.demo.service;

import com.diseno.demo.dto.request.CommentDTO;
import com.diseno.demo.dto.response.GetCommentDTO;
import com.diseno.demo.entity.Comment;
import com.diseno.demo.entity.Requirement;
import com.diseno.demo.entity.user.User;
import com.diseno.demo.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final RequirementService requirementService;
    private final UserService userService;

    public void createComment(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        //todo configurar el modelMapper
        commentRepository.save(comment);
    }

    public ResponseEntity<GetCommentDTO> getCommentDTOById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(this.getCommentById(id), GetCommentDTO.class));
    }

    public ResponseEntity<List<GetCommentDTO>> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(comments.stream().map(comment -> modelMapper.map(comment, GetCommentDTO.class)).toList());
    }

    public void updateComment(Long id, CommentDTO commentDTO) {
        Comment commentToUpdate = getCommentById(id);

        if (commentDTO.getSubject() != null){
            commentToUpdate.setSubject(commentDTO.getSubject());
        }
        if (commentDTO.getDescription() != null){
            commentToUpdate.setDescription(commentDTO.getDescription());
        }
        if (commentDTO.getRequirementId() != null){
            Requirement requirement = requirementService.getRequirementById(commentDTO.getRequirementId());
            commentToUpdate.setRequirement(requirement);
        }
        if (commentDTO.getUserId() != null){
            User user = userService.getUserById(commentDTO.getUserId());
            commentToUpdate.setUser(user);
        }

        commentRepository.save(commentToUpdate);
    }

    private Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment with id " + id + " not found"));
    }
}
