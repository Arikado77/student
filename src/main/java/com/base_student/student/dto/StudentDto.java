package com.base_student.student.dto;

import com.base_student.student.StudentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @JsonIgnore
    private Integer id;
    private String name;
    private String lastName;
    private String phone;
    private String email; 

    public StudentModel toModel() {
        return StudentModel.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .phone(this.phone)
                .email(this.email)
                .build();
    }
}