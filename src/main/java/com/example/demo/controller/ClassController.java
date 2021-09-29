package com.example.demo.controller;

import com.example.demo.dto.ClassResource;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public ResponseEntity<List<ClassResource>> getClasses() {
        return new ResponseEntity<>(classService.getClasses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassResource> getClass(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(classService.getClass(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) throws Exception {
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ClassResource> registerNewClass(@RequestBody ClassResource classResource) {

        return new ResponseEntity<>(classService.addNewClass(classResource), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassResource> updateFullClass(@PathVariable Long id, @RequestBody ClassResource classResource) {
        return new ResponseEntity<>(classService.updateFullClass(classResource, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClassResource> updatePartialClass(@PathVariable Long id, @RequestBody ClassResource classResource) {
        return new ResponseEntity<>(classService.updatePartialClass(classResource, id), HttpStatus.ACCEPTED);
    }
}
