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
}
