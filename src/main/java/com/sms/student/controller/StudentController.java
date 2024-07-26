package com.sms.student.controller;

import com.sms.student.Payload.StudentDto;
import com.sms.student.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

   /* @GetMapping
    public ResponseEntity<String> getStudent () {
        return ResponseEntity.ok("No students added yet.");
    }*/

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent (@Valid @RequestBody StudentDto studentDto) {
        StudentDto createStudentDto = this.studentService.createStudent(studentDto);
        return new ResponseEntity<>(createStudentDto, HttpStatus.CREATED);
    }
}
