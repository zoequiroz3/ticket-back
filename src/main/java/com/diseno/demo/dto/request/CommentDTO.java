package com.diseno.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CommentDTO {

    @NotNull(message = "subject must be not null")
    private String subject;

    @NotNull(message = "description must be not null")
    private String description;

    @NotNull(message = "requirementId must be not null")
    @Positive(message = "requirementId must be a positive number")
    private Long requirementId;

    @NotNull(message = "userId must be not null")
    @Positive(message = "userId must be a positive number")
    private Long userId;
}
