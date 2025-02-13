package com.javiervictoriano.social_service.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId; // references the user in user_service

    @Column(name = "routine_log_id", nullable = false)
    private UUID routineLogId; // references the routine log in workout_service    

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;    

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }
}
