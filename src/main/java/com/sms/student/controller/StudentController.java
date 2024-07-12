package com.sms.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping
    public ResponseEntity<String> getStudent () {
        return ResponseEntity.ok("No students added yet.");
    }

    @PostMapping
    public ResponseEntity<String> postStudent () {
        return ResponseEntity.ok("Give some data.");
    }
}
