package com.diseno.demo.dto.request;

import lombok.Data;

@Data
public class CommentDTO {
    private String subject;
    private String description;
    private Long requirementId;
    private Long userId; //todo preguntar al front si prefiere ido userdto
}
