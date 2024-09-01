package com.sms.student.controller;

import com.sms.student.Entity.Teacher;
import com.sms.student.Payload.ApiResponse;
import com.sms.student.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    public TeacherService teacherService;

    // post mapping

    @PostMapping("/create")
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
        Teacher teacher1 = this.teacherService.createTeacher(teacher);
        return new ResponseEntity<>(teacher1, HttpStatus.CREATED);
    }

    // get teacher
    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable ("teacherId") Integer teacherId){
        Teacher teacherById = this.teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacherById);
    }

    //get all teacher
    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllStudent(
            @RequestParam(value="pageNumber",defaultValue ="0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
            ){
       return ResponseEntity.ok(this.teacherService.getAllTeacher(pageNumber,pageSize));
    }

    // update teacher
    @PutMapping("/{teacherId}")
    public ResponseEntity<ApiResponse> updateTeacher(@RequestBody Teacher teacher,@PathVariable("teacherId") Integer teacherId){
        Teacher teacher1 = this.teacherService.updateTeacher(teacher, teacherId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher is updated Successfully",true),HttpStatus.OK);
    }

    //delete teacher
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("teacherId") Integer teacherId){
        this.teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher deleted successfully",true),HttpStatus.OK);
    }

   /* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }*/
}
