package com.tutorbase.backend.service;

import com.tutorbase.backend.dto.SessionLogDTO;
import com.tutorbase.backend.entity.Schedule;
import com.tutorbase.backend.entity.SessionLog;
import com.tutorbase.backend.mapper.SessionLogMapper;
import com.tutorbase.backend.repository.ScheduleRepository;
import com.tutorbase.backend.repository.SessionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionLogService {
    @Autowired
    private SessionLogRepository sessionLogRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SessionLogMapper sessionLogMapper;

    public SessionLogDTO createSessionLog(SessionLogDTO dto) {
        SessionLog log = sessionLogMapper.toEntity(dto);

        Schedule schedule = scheduleRepository.findById(dto.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        log.setSchedule(schedule);

        SessionLog saved = sessionLogRepository.save(log);
        return sessionLogMapper.toDTO(saved);
    }

    public List<SessionLogDTO> getAllLogs() {
        return sessionLogRepository.findAll().stream()
                .map(sessionLogMapper::toDTO)
                .toList();
    }

    public SessionLogDTO getLogByScheduleId(Long scheduleId) {
        SessionLog log = sessionLogRepository.findBySchedule_ScheduleId(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        return sessionLogMapper.toDTO(log);
    }

    public SessionLogDTO getLogBySessionId(Long sessionId) {
        SessionLog log = sessionLogRepository.findById(sessionId).orElse(null);
        return sessionLogMapper.toDTO(log);
    }

    public SessionLogDTO updateSessionLog(Long id,SessionLogDTO dto) {
        SessionLog log = sessionLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session log not found"));

        log.setHomeworkAssigned(dto.getHomeworkAssigned());
        log.setLastHomeworkStatus(dto.getLastHomeworkStatus());
        log.setRemarks(dto.getRemarks());

        sessionLogRepository.save(log);

        return sessionLogMapper.toDTO(log);
    }

    @Transactional
    public void deleteSessionLog(Long id) {
        if(!sessionLogRepository.existsById(id)) throw new RuntimeException("Session log not found");
        sessionLogRepository.deleteById(id);
    }
}
