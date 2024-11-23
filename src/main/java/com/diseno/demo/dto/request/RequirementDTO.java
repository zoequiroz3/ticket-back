package com.diseno.demo.dto.request;

import com.diseno.demo.entity.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;

@Data
public class RequirementDTO {
    @NotBlank(message = "Subject cannot be blank")
    private final String subject;

    private final String description;

    @NotNull(message = "Priority cannot be null")
    private final Priority priority;

    private final HashSet<Long> requirementsIds;

    @NotNull(message = "Category id cannot be null")
    private final Long categoryId;

    @NotNull(message = "Creator id cannot be null")
    private final Long creatorId;

    @NotNull(message = "Type id cannot be null")
    private Long typeId;

    private final Long assigneeId;
}
