package com.diseno.demo.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inside_user")
public class InsideUser extends User {

    private InsideUser() {
    }

    public InsideUser(String email, String username, String name, String position, String department, Integer userFile, Boolean sla) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.position = position;
        this.department = department;
        this.userFile = userFile;
        this.sla = sla;
    }
}