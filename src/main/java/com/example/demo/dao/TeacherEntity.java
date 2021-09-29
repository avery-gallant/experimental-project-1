package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class TeacherEntity extends PersonEntity {
    @Id
    @SequenceGenerator(
            name = "teacher_id_seq",
            sequenceName = "teacher_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_id_seq"
    )
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "salary")
    private float salary;

    @OneToMany(mappedBy = "teacherEntity")
    private List<ClassEntity> classEntityList;
}
