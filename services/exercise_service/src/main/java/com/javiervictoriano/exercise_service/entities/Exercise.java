package com.javiervictoriano.exercise_service.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "user_id", nullable = true)
    private UUID userID; // reference to user in user_service and if null it means it's a global exercise

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private String name;

    @Column(name = "muscle_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Equipment equipment;

    @Column(name = "uses_repetition", nullable = false)
    private boolean usesRepetition = false;

    @Column(name = "uses_weights", nullable = false)
    private boolean usesWeights = false;

    @Column(name = "uses_time", nullable = false)
    private boolean usesTime = false;
}
