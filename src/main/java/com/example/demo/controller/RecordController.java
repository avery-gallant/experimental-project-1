package com.example.demo.controller;

import com.example.demo.dto.RecordResource;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping
    public ResponseEntity<List<RecordResource>> getRecords() {
        return new ResponseEntity<>(recordService.getRecords(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordResource> getRecord(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(recordService.getRecord(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) throws Exception {
        recordService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<RecordResource> registerNewRecord(@RequestBody RecordResource record) {

        return new ResponseEntity<>(recordService.addNewRecord(record), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordResource> updateFullRecord(@PathVariable Long id, @RequestBody RecordResource record) {
        return new ResponseEntity<>(recordService.updateFullRecord(record, id), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecordResource> updatePartialRecord(@PathVariable Long id, @RequestBody RecordResource record) {
        return new ResponseEntity<>(recordService.updatePartialRecord(record, id), HttpStatus.ACCEPTED);
    }
}
