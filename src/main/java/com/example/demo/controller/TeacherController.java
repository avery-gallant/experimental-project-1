package com.example.demo.controller;

import com.example.demo.dto.TeacherResource;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResource>> getTeachers() {
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResource> getTeacher(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(teacherService.getTeacher(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) throws Exception {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<TeacherResource> registerNewTeacher(@RequestBody TeacherResource teacher) {

        return new ResponseEntity<>(teacherService.addNewTeacher(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResource> updateFullTeacher(@PathVariable Long id, @RequestBody TeacherResource teacher) {
        return new ResponseEntity<>(teacherService.updateFullTeacher(teacher, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeacherResource> updatePartialTeacher(@PathVariable Long id, @RequestBody TeacherResource teacher) {
        return new ResponseEntity<>(teacherService.updatePartialTeacher(teacher, id), HttpStatus.ACCEPTED);
    }
}
