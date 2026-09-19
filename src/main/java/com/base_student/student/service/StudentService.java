package com.base_student.student.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.base_student.student.dto.StudentDto;
import com.base_student.student.StudentModel;
import com.base_student.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {
        List<StudentModel> students = studentRepository.findAll();
        // Convertimos la lista de modelos a lista de DTOs
        return students.stream()
                .map(StudentModel::toDto)
                .collect(Collectors.toList());
    }

    public StudentDto save(StudentDto studentDto) {
        StudentModel student = studentDto.toModel();
        StudentModel savedStudent = studentRepository.save(student);
        return savedStudent.toDto();
    }

    public void deleteById(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con el ID: " + id);
        }
        studentRepository.deleteById(id);
    }
}