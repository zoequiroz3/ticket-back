package com.diseno.demo.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "outside_user")
public class OutsideUser extends User {

    @Column(unique = true)
    private String cuil;

    @Column(length = 500)
    private String description;

    private String company;

    private OutsideUser(){
    }

    public OutsideUser(String email, String username, String name, String position, String department, Integer userFile, String cuil, String description, String company, Boolean sla) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.position = position;
        this.department = department;
        this.userFile = userFile;
        this.cuil = cuil;
        this.description = description;
        this.company = company;
        this.sla = sla;

    }
}
