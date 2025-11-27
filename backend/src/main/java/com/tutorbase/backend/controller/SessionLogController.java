package com.tutorbase.backend.controller;


import com.tutorbase.backend.dto.SessionLogDTO;
import com.tutorbase.backend.entity.SessionLog;
import com.tutorbase.backend.service.SessionLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session-logs")
@CrossOrigin(origins = "*")
public class SessionLogController {

    @Autowired
    private SessionLogService sessionLogService;

    @PostMapping
    public SessionLogDTO createLog(@Valid @RequestBody SessionLogDTO sessionLogDTO) {
        return sessionLogService.createSessionLog(sessionLogDTO);
    }

    @GetMapping("schedule/{id}")
    public SessionLogDTO getLogByScheduleId(@PathVariable Long id) {
        return sessionLogService.getLogByScheduleId(id);
    }

    @GetMapping("session/{id}")
    public SessionLogDTO getLogBySessionId(@PathVariable Long id) {
        return sessionLogService.getLogBySessionId(id);
    }

    @GetMapping
    public List<SessionLogDTO> getAllLogs() {
        return sessionLogService.getAllLogs();
    }

    @PutMapping("/{id}")
    public SessionLogDTO updateLog(@PathVariable Long id,@Valid @RequestBody SessionLogDTO sessionLogDTO) {
        return sessionLogService.updateSessionLog(id,sessionLogDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        sessionLogService.deleteSessionLog(id);
    }
}
