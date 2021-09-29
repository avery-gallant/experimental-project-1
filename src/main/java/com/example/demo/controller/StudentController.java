package com.example.demo.controller;

import com.example.demo.dto.StudentResource;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Student controller.
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Gets students.
     *
     * @return the students
     */
    @GetMapping
    public ResponseEntity<List<StudentResource>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    /**
     * Gets student.
     *
     * @param id the id
     * @return the student
     * @throws Exception the exception
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentResource> getStudent(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    /**
     * Delete student response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws Exception the exception
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Register new student response entity.
     *
     * @param student the student
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<StudentResource> registerNewStudent(@RequestBody StudentResource student) {

        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    /**
     * Update full student response entity.
     *
     * @param id      the id
     * @param student the student
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentResource> updateFullStudent(@PathVariable Long id, @RequestBody StudentResource student) {
        return new ResponseEntity<>(studentService.updateFullStudent(student, id), HttpStatus.ACCEPTED);
    }

    /**
     * Update partial student response entity.
     *
     * @param id      the id
     * @param student the student
     * @return the response entity
     */
    @PatchMapping("/{id}")
    public ResponseEntity<StudentResource> updatePartialStudent(@PathVariable Long id, @RequestBody StudentResource student) {
        return new ResponseEntity<>(studentService.updatePartialStudent(student, id), HttpStatus.ACCEPTED);
    }
}
