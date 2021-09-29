package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grade")
@Getter
@Setter
public class GradeEntity {
    @EmbeddedId
    private GradeId id = new GradeId();

    @Column(name = "grade")
    private float grade;

    @ManyToOne(optional = false)
    @MapsId("recordId")
    //@JoinColumn(name = "record_id")
    private RecordEntity recordEntity;

    @ManyToOne(optional = false)
    @MapsId("classId")
    //@JoinColumn(name = "class_id")
    private ClassEntity classEntity;
}
