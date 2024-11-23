package com.diseno.demo.dto.response;

import lombok.Data;

@Data
public class GetCategoryDTO {
    private Long id;
    private String description;
    private GetTypeDTO type;
}
