package com.tutorbase.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SessionLogDTO {

    private Long logId;

    @NotNull(message = "schedule id required")
    private Long scheduleId;

    private String studentName;
    private String classDate;

    private String homeworkAssigned;
    private Boolean lastHomeworkStatus;
    private String remarks;
}
