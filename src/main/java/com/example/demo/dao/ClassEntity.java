package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
@Getter
@Setter
public class ClassEntity {
    @Id
    @SequenceGenerator(
            name = "class_id_seq",
            sequenceName = "class_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_id_seq"
    )
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "name")
    private String name;

    @Column(name = "attendees")
    private Integer attendees;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @OneToMany(mappedBy = "classEntity")
    private List<GradeEntity> gradeEntityList;

    @ManyToMany(mappedBy = "classEntityList")
    private List<StudentEntity> studentEntityList;
}
