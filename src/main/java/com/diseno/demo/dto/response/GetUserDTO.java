package com.diseno.demo.dto.response;

import lombok.Data;

@Data
public class GetUserDTO {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String position;
    private String department;
    private Integer userFile;
    private Boolean sla;
    private String cuil;
    private String company;
    private String description;
}
