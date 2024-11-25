package com.diseno.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    //todo poner validaciones a este dto y a todos
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String username;
    private String name;
    private String position;
    private String department;
    private Integer userFile;
    private Boolean sla;
    private String cuil;
    private String description;
    private String company;
}
