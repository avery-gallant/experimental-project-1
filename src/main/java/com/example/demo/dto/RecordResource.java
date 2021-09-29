package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RecordResource {
    private Long recordId;
    private Long studentId;
    private Float gradePointAverage;
    private List<Long> gradeIds;

}
