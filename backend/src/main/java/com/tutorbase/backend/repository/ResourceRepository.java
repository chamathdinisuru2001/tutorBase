package com.tutorbase.backend.repository;


import com.tutorbase.backend.entity.Resource;
import com.tutorbase.backend.enums.GradeLevel;
import com.tutorbase.backend.enums.Subject;
import com.tutorbase.backend.enums.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByGradeAndSubjectAndTerm(GradeLevel grade, Subject subject, Term term);
}
