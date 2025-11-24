package com.tutorbase.backend.service;

import com.tutorbase.backend.dto.StudentDTO;
import com.tutorbase.backend.entity.Student;
import com.tutorbase.backend.mapper.StudentMapper;
import com.tutorbase.backend.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return studentMapper.toDTO(student);
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setFullName(studentDTO.getFullName());
        existingStudent.setGradeLevel(studentDTO.getGradeLevel());
        existingStudent.setParentPhone(studentDTO.getParentPhone());
        existingStudent.setLocationLink(studentDTO.getLocationLink());

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toDTO(updatedStudent);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new RuntimeException("Student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}
