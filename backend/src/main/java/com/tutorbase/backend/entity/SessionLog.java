package com.tutorbase.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "session_logs")
public class SessionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @OneToOne
    @JoinColumn(name = "schedule_id", nullable = false, unique = true)
    private Schedule schedule;

    @Column(columnDefinition = "TEXT")
    private String homeworkAssigned;

    private Boolean lastHomeworkStatus;

    @Column(columnDefinition = "TEXT")
    private String remarks;

}
