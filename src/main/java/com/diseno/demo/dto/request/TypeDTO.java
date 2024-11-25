package com.diseno.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TypeDTO {

    @NotBlank(message = "description must be not blank")
    @Size(max = 50)
    private String description;

    @NotNull(message = "Code must be not null")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Code must be 3 uppercase letters")
    private String code;
}
