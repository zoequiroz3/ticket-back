package com.diseno.demo.dto;

import lombok.Data;

@Data
public class GetRequirementDTO {
    private Long id;
    private String subject;
    private String description;
    private String priority;
    private Long categoryId;
    private Long creatorId;
    private Long assigneeId;
}
