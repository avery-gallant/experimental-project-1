package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PersonResource {
    private String name;
    private LocalDate dateOfBirth;
    private Integer age;
}
