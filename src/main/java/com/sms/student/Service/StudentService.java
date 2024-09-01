package com.sms.student.Service;

import com.sms.student.Entity.Student;

import java.util.List;

public interface StudentService {
   Student createStudent(Student student);
   Student updateStudent(Student student,Integer studentId);
   Student getStudentById(Integer studentId);
   List<Student> getAllStudent(Integer pageNumber,Integer pageSize);
   void deleteStudent(Integer studentId);

}
