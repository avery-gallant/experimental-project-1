package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GradeResource {
    private Float grade;
    private ClassResource course;
    private RecordResource record;
}
