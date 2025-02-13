package com.javiervictoriano.user_service.entities;

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
@Table(name = "followers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {

    @EmbeddedId
    private FollowerId id;

    @ManyToOne()
    @MapsId("followerId")
    @JoinColumn(name = "follower_id", referencedColumnName = "id", nullable = false)
    private Users follower;

    @ManyToOne()
    @MapsId("targetId")
    @JoinColumn(name = "target_id", referencedColumnName = "id", nullable = false)
    private Users target;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }
}
