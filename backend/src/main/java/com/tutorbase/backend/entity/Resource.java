package com.tutorbase.backend.entity;


import com.tutorbase.backend.enums.GradeLevel;
import com.tutorbase.backend.enums.Subject;
import com.tutorbase.backend.enums.Term;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String fileURL;

    @Enumerated(EnumType.STRING)
    private GradeLevel grade;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Enumerated(EnumType.STRING)
    private Term term;

    private LocalDateTime uploadedAt;

    @PrePersist
    protected void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }
}
