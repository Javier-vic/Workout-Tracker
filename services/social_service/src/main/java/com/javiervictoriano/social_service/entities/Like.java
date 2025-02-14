package com.javiervictoriano.social_service.entities;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @EmbeddedId
    private LikeId id;

    @ManyToOne()
    @MapsId("postId")
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Post post;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;
    
    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }
}
