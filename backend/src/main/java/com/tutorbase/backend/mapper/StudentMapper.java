package com.tutorbase.backend.mapper;

import com.tutorbase.backend.dto.StudentDTO;
import com.tutorbase.backend.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);
}
