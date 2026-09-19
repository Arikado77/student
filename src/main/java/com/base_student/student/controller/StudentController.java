// Este mensaje es una prueba para los commits
package com.base_student.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // Cambiado a RestController

import com.base_student.student.dto.StudentDto;
import com.base_student.student.service.StudentService;

@RestController // Es mejor práctica para APIs que @Controller
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<StudentDto> studentsDtos = studentService.findAll();
        return new ResponseEntity<>(studentsDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) {
        try {
            StudentDto savedStudent = studentService.save(studentDto);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED); // Código 201
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            studentService.deleteById(id);
            return new ResponseEntity<>("Estudiante eliminado correctamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // Código 404
        }
    }
}