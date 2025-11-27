package com.tutorbase.backend.entity;

import com.tutorbase.backend.enums.ClassStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDateTime classDate;

    @Enumerated(EnumType.STRING)
    private ClassStatus status;
}
