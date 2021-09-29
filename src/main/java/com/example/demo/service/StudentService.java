package com.example.demo.service;


import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.StudentResource;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResource> getStudents() {
        return StudentMapper.INSTANCE.toResources(studentRepository.findAll());
    }


    public StudentResource getStudent(Long id) throws Exception {
        studentExists(id);
        return StudentMapper.INSTANCE.toResource(studentRepository.findById(id).get());
    }


    public void deleteStudent(Long id) throws EntityNotFoundException {
        studentExists(id);
        studentRepository.deleteById(id);
    }

    private void studentExists(Long id) throws EntityNotFoundException {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student does not exist");
        }
    }

    public StudentResource addNewStudent(StudentResource student) {
        return StudentMapper.INSTANCE.toResource(studentRepository.save(StudentMapper.INSTANCE.toEntity(student)));
    }

    public StudentResource updateFullStudent(StudentResource student, Long id) throws EntityNotFoundException {
        studentExists(id);
        if (student.getStudentId() == null) {
            student.setStudentId(id);
        }
        return StudentMapper.INSTANCE.toResource(studentRepository.save(StudentMapper.INSTANCE.toEntity(student)));
    }

    public StudentResource updatePartialStudent(StudentResource studentResource, Long id) throws EntityNotFoundException {
        studentExists(id);
        StudentEntity studentEntity = studentRepository.getById(id);

        if (studentResource.getAge() != null)
            studentEntity.setAge(studentResource.getAge());

        if (studentResource.getStudentId() != null)
            studentEntity.setStudentId(studentResource.getStudentId());

        if (studentResource.getDateOfBirth() != null)
            studentEntity.setDob(studentResource.getDateOfBirth());

        if (studentResource.getEmail() != null)
            studentEntity.setEmail(studentResource.getEmail());

        if (studentResource.getName() != null)
            studentEntity.setName(studentResource.getName());

        //if (studentResource.getClasses() != null)
        //    studentEntity.setClassEntityList(ClassMapper.INSTANCE.toEntities(studentResource.getClasses()));

        //if (studentResource.getRecord() != null)
        //    studentEntity.setRecordEntity(RecordMapper.INSTANCE.toEntity(studentResource.getRecord()));
        return StudentMapper.INSTANCE.toResource(studentRepository.save(studentEntity));

    }

}
