package com.base_student.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base_student.student.dto.StudentDto;
import com.base_student.student.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?>findAll() {
        List<StudentDto> studentsDtos = studentService.findAll();
        return new ResponseEntity<>(studentsDtos, HttpStatus.OK);
    }

}
