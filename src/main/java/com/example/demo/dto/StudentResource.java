package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentResource {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private int age;
}
