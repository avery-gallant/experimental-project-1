package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClassResource {

    private Long classId;
    private String name;
    private Integer attendees;
    private Long teacherId;
    private List<Long> gradeIds;
    private List<Long> studentIds;
}
