package com.sms.student.Service;

import com.sms.student.Payload.StudentDto;

import java.util.List;

public interface StudentService {
   StudentDto createStudent(StudentDto student);
   StudentDto updateStudent(StudentDto student,Integer StudentId);
   StudentDto getStudentById(Integer StudentId);
   List<StudentDto> getAllStudent();
   void deleteStudent(Integer StudentId);

}
