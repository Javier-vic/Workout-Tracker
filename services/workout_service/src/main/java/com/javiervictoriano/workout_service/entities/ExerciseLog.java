package com.javiervictoriano.workout_service.entities;

import java.sql.Timestamp;
import java.time.Duration;
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
@Table(name = "exercise_logs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseLog {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "exercise_id", nullable = false)
    private UUID exerciseID;

    @ManyToOne
    @JoinColumn(name = "routine_log_id", nullable = false)
    private RoutineLog routineLog;

    @Column(nullable = false)
    private int repetitions = 0;

    @Column(nullable = false)
    private double weight = 0.0;

    @Column(nullable = false, columnDefinition = "INTERVAL")
    private Duration duration = Duration.ZERO;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }

}
