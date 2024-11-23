package com.diseno.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false, length = 3)
    @Pattern(regexp = "^[A-Z]{3}$", message = "Code must be 3 uppercase letters")
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private Type (){
    }

    @PrePersist
    private void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
