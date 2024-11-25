package com.diseno.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Email is mandatory")
    private String email;

    private String username;

    @NotBlank(message = "user must be not blank" )
    private String name;

    private String position;
    private String department;
    private Integer userFile;

    @NotNull(message = "sla must be not null")
    private Boolean sla;

    private String cuil;

    @Size(max = 500, message = "description must be less than 500 characters")
    private String description;

    private String company;
}
