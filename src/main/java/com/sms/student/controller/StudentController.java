package com.sms.student.controller;

import com.sms.student.Entity.Student;
import com.sms.student.Exception.ResourceNotFoundException;
import com.sms.student.Payload.ApiResponse;
import com.sms.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = this.studentService.createStudent(student);
        return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(this.studentService.getAllStudent());
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("studentId") Integer studentId) {
        Student updatedStudent = this.studentService.updateStudent(student, studentId);
        return ResponseEntity.ok(updatedStudent);

    }

    // get single student
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getById(@PathVariable("studentId") Integer studentId){
        Student singleStudent = this.studentService.getStudentById(studentId);
        return ResponseEntity.ok(singleStudent);

    }
    //delete student from database
    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable ("studentId") Integer studentId){
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Student Deleted successfully",true),HttpStatus.OK);
    }

}
