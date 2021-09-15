package com.example.demo.service;

import com.example.demo.dto.StudentResource;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteStudent(Long id) throws Exception {
        studentExists(id);
        studentRepository.deleteById(id);
    }

    private void studentExists(Long id) throws Exception {
        if (!studentRepository.existsById(id)) {
            throw new Exception("Student does not exist");
        }
    }
//    public Student addStudent (Student student){
//        Student newStudent = Student.builder().Name("Jeff").age(21).build();
//    }
}
