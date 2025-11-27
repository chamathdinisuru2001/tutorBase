package com.tutorbase.backend.dto;

import com.tutorbase.backend.enums.ClassStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScheduleDTO {
    private Long scheduleId;

    @NotNull(message = "Student ID required")
    private Long studentId;

    private String studentName;

    @NotNull(message = "class date and time required")
    private String classDate;

    private ClassStatus status;
}
