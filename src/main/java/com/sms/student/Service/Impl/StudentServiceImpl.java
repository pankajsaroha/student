package com.sms.student.Service.Impl;

import com.sms.student.Entity.Student;
import com.sms.student.Exception.ResourceNotFoundException;
import com.sms.student.Repositories.StudentRepo;
import com.sms.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public Student createStudent(Student student) {
        Student created = this.studentRepo.save(student);
        return created;
    }

    @Override
    public Student updateStudent(Student student, Integer studentId) {
        Student student1=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found with student id:"+studentId));
        return null;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student studentById = this.studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student not found with student id:"+studentId));
        return studentById;
    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> all = this.studentRepo.findAll();
       // List<Student> collect = all.stream().map(data -> this.Student(data)).collect(Collectors.toList());
        return all;
    }

    // delete student service
    @Override
    public void deleteStudent(Integer studentId) {

        Student student=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found with student id:"+studentId));
        this.studentRepo.delete(student);
    }
}
