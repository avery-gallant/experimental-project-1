package com.example.demo.service;

import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.StudentResource;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentServiceTests {
    @Autowired
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepositoryMock;
    private StudentEntity studentEntity;

    @BeforeEach
    public void setup() {
        studentRepositoryMock = Mockito.mock(StudentRepository.class);
        studentEntity = new StudentEntity();
        studentEntity.setStudentId(Long.MAX_VALUE);
    }

    @Test
    public void getStudentsTest() {
        Mockito.when(studentRepositoryMock.findAll()).thenReturn(List.of(studentEntity));
        List<StudentResource> studentResourceList = studentService.getStudents();
        Assertions.assertNotNull(studentResourceList);
        Assertions.assertFalse(studentResourceList.isEmpty());
        Assertions.assertEquals(studentResourceList.get(0).getStudentId(), studentEntity.getStudentId());
    }

}
