package com.base_student.student.dto;

import com.base_student.student.StudentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.ObjectMapper;

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
    private String eMail;

    public StudentModel toModel() {
        return StudentModel.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .phone(this.phone)
                .email(this.eMail)
                .build();
    }

    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}