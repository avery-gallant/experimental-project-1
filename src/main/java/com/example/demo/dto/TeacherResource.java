package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TeacherResource extends PersonResource {
    private Long teacherId;
    private Float salary;
    private List<Long> classIds;

    @Builder
    public TeacherResource(Long teacherId, String name, Float salary, LocalDate dateOfBirth, Integer age, List<Long> classIds) {
        super(name, dateOfBirth, age);
        this.teacherId = teacherId;
        this.salary = salary;
        this.classIds = classIds;
    }
}
