package com.tutorbase.backend.controller;


import com.tutorbase.backend.dto.ScheduleDTO;
import com.tutorbase.backend.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleDTO getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PostMapping
    public ScheduleDTO createSchedule(@Valid @RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.createSchedule(scheduleDTO);
    }

    @PutMapping("/{id}")
    public ScheduleDTO updateSchedule(@PathVariable Long id, @Valid @RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(id, scheduleDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return "Schedule deleted";
    }
}
