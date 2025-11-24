package com.tutorbase.backend.dto;

import com.tutorbase.backend.enums.GradeLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentDTO {
    private  Long studentId;

    @NotBlank(message = "Name required")
    private String fullName;

    @NotNull(message = "Grade required")
    private GradeLevel gradeLevel;

    @NotBlank(message = "Phone number required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must have 10 digits")
    private String parentPhone;

    private String locationLink;
}
