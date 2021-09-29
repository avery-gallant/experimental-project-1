package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "record")
@Getter
@Setter
public class RecordEntity {
    @Id
    @SequenceGenerator(
            name = "record_id_seq",
            sequenceName = "record_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "record_id_seq"
    )
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "gpa")
    private Float gpa;

    @OneToOne(mappedBy = "recordEntity")
    private StudentEntity studentEntity;

    @OneToMany(mappedBy = "recordEntity")
    private List<GradeEntity> gradeEntityList;
}
