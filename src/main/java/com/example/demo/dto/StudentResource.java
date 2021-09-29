package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Student resource.
 */
@Getter
@Setter
public class StudentResource extends PersonResource {


    private Long studentId;
    private String email;
    private Long recordId;
    private List<Long> classIds;

    @Builder
    public StudentResource(Long studentId, String name, String email, LocalDate dateOfBirth, Integer age, Long recordId, List<Long> classIds) {
        super(name, dateOfBirth, age);
        this.studentId = studentId;
        this.email = email;
        this.recordId = recordId;
        this.classIds = classIds;
    }
}
