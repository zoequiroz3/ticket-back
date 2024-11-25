package com.diseno.demo.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank (message = "description must be not blank")
    @Size(max = 50)
    private String description;
    
    @NotNull(message = "typeId must be not null")
    @Positive(message = "typeId must be a positive number")
    private Long typeId;
}
