package com.tutorbase.backend.repository;

import com.tutorbase.backend.entity.SessionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionLogRepository extends JpaRepository<SessionLog, Long> {

    Optional<SessionLog> findBySchedule_ScheduleId(Long scheduleId);
}
