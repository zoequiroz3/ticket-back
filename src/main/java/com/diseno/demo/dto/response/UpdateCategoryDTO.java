package com.diseno.demo.dto.response;

import lombok.Data;

@Data
public class UpdateCategoryDTO {
    private Long id;
    private String description;
    private Long typeId;
}
