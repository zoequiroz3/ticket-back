package com.diseno.demo.dto.request;

import com.diseno.demo.entity.Priority;
import lombok.Data;

import java.util.HashSet;

@Data
public class UpdateRequirementDTO {

    private String subject;
    private String description;
    private Priority priority;
    private Long categoryId;
    private Long assigneeId;
    private HashSet<Long> requirementsIds;

}
