package com.tutorbase.backend.mapper;

import com.tutorbase.backend.dto.ScheduleDTO;
import com.tutorbase.backend.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    @Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "student.fullName", target ="studentName")
    ScheduleDTO toDTO(Schedule schedule);

    @Mapping(target = "student", ignore = true)
    Schedule toEntity(ScheduleDTO scheduleDTO);

}
