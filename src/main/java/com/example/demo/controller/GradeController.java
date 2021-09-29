package com.example.demo.controller;

import com.example.demo.dto.GradeResource;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<GradeResource>> getGrades() {
        return new ResponseEntity<>(gradeService.getGrades(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeResource> getGrade(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(gradeService.getGrade(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) throws Exception {
        gradeService.deleteGrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<GradeResource> registerNewGrade(@RequestBody GradeResource grade) {

        return new ResponseEntity<>(gradeService.addNewGrade(grade), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeResource> updateFullGrade(@PathVariable Long id, @RequestBody GradeResource grade) {
        return new ResponseEntity<>(gradeService.updateFullGrade(grade, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GradeResource> updatePartialGrade(@PathVariable Long id, @RequestBody GradeResource grade) {
        return new ResponseEntity<>(gradeService.updatePartialGrade(grade, id), HttpStatus.ACCEPTED);
    }
}
