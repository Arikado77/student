package com.base_student.student.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.base_student.student.StudentModel;
import com.base_student.student.dto.StudentDto;
import com.base_student.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(StudentModel::toDto).toList();
    }
}

