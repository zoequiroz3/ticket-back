package com.diseno.demo.entity;

import com.diseno.demo.entity.user.InsideUser;
import com.diseno.demo.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String subject;

    @Column(nullable = false,unique = true, length = 19)
    private String code;

    @Column(length = 5000)
    private String description;

    private State state = State.OPEN;
    private Priority priority;

    @ManyToMany
    private Set<Requirement> requirements;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @OneToOne(fetch = FetchType.EAGER)
    private User creator;
    @ManyToOne(fetch = FetchType.EAGER)
    private InsideUser assignee;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Requirement() {
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
