package com.javiervictoriano.user_service.entities;

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
public class FollowerId {

    @Column(name = "follower_id", nullable = false)
    private UUID followerId;

    @Column(name = "target_id", nullable = false)
    private UUID targetId;
}
