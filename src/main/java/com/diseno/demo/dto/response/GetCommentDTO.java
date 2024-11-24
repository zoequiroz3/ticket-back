package com.diseno.demo.dto.response;

import lombok.Data;

@Data
public class GetCommentDTO {
    private Long id;
    private String subject;
    private String description;
    private Long requirementId;
    private Long userId; //todo preguntar al front si prefiere ido userdto
}
