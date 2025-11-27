package com.tutorbase.backend.service;


import com.tutorbase.backend.dto.ScheduleDTO;
import com.tutorbase.backend.entity.Schedule;
import com.tutorbase.backend.entity.Student;
import com.tutorbase.backend.enums.ClassStatus;
import com.tutorbase.backend.mapper.ScheduleMapper;
import com.tutorbase.backend.repository.ScheduleRepository;
import com.tutorbase.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    public List<ScheduleDTO>getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(scheduleMapper::toDTO)
                .toList();
    }

    public ScheduleDTO getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        return scheduleMapper.toDTO(schedule);
    }

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);

        Student student = studentRepository.findById(scheduleDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        schedule.setStudent(student);

        if (schedule.getStatus() == null){
            schedule.setStatus(ClassStatus.PENDING);
        }

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDTO(savedSchedule);
    }

    public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        schedule.setStatus(scheduleDTO.getStatus());
        return scheduleMapper.toDTO(scheduleRepository.save(schedule));
    }

    public void deleteSchedule(Long id) {
        if(!scheduleRepository.existsById(id))throw new RuntimeException("Schedule not found");
        scheduleRepository.deleteById(id);
    }
}
