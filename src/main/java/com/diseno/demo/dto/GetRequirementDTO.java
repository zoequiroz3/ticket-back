package com.diseno.demo.dto;

import com.diseno.demo.entity.Type;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class GetRequirementDTO {
    private Long id;
    private String code;
    private String subject;
    private String description;
    private String priority;
    private Long categoryId;
    private Long creatorId; //todo change to userdto
    private Long assigneeId; //todo change to insideuserdto
    private Set<Long> requirementsIds; //todo change to requirementsdto
    private LocalDate date;
    private LocalTime time;
}
