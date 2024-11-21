package com.diseno.demo.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "inside_user")
public class InsideUser extends User {

    private InsideUser() {
    }
}