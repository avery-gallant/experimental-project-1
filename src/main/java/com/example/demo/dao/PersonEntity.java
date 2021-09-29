package com.example.demo.dao;

import lombok.Data;

import java.time.LocalDate;

//@Entity
//@Inheritance
@Data
public class PersonEntity {
    //@Column(name = "name")
    private String name;
    //@Column(name = "dob")
    private LocalDate dob;
    //@Column(name = "age")
    private Integer age;
}
