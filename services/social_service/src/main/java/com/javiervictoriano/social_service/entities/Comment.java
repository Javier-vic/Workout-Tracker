package com.javiervictoriano.social_service.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId; // references the user in user_service

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;

    @Column(length = 1000, nullable = false)
    private String comment;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }
}
