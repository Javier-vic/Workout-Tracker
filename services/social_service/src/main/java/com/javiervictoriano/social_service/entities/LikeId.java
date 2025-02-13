package com.javiervictoriano.social_service.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LikeId {

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "post_id", nullable = false)
    private UUID postId;
}
