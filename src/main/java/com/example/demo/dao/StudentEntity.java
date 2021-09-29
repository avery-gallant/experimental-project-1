package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * The type Student entity.
 */
@Entity
@Table(name = "student")
@Getter
@Setter
public class StudentEntity extends PersonEntity {
    @Id
    @SequenceGenerator(
            name = "student_id_seq",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_seq"
    )
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_record",
            joinColumns = @JoinColumn(name = "student", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "record", referencedColumnName = "record_id")
    )
    private RecordEntity recordEntity;

    @ManyToMany
    @JoinTable(
            name = "student_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<ClassEntity> classEntityList;

}
