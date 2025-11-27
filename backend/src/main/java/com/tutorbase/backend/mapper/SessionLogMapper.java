package com.tutorbase.backend.mapper;

import com.tutorbase.backend.dto.SessionLogDTO;
import com.tutorbase.backend.entity.SessionLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessionLogMapper {

    @Mapping(source = "schedule.scheduleId",target = "scheduleId")
    @Mapping(source = "schedule.student.fullName", target = "studentName")
    @Mapping(source = "schedule.classDate", target = "classDate", dateFormat = "yyyy-MM-dd HH:mm")
    SessionLogDTO toDTO(SessionLog sessionLog);

    @Mapping(target = "schedule", ignore = true)
    SessionLog toEntity(SessionLogDTO sessionLogDTO);
}
