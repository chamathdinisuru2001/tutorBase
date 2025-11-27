package com.tutorbase.backend.entity;

import com.tutorbase.backend.enums.GradeLevel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private GradeLevel gradeLevel;

    private String parentPhone;
    private String locationLink;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
