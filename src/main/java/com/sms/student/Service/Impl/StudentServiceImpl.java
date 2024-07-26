package com.sms.student.Service.Impl;

import com.sms.student.Entity.Student;
import com.sms.student.Payload.StudentDto;
import com.sms.student.Repositories.StudentRepo;
import com.sms.student.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    // create Student service
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student1 = this.dtoToStudent(studentDto);
        Student savedStudent=this.studentRepo.save(student1);
        return this.studentToDto(savedStudent);
    }

    @Override
    public StudentDto updateStudent(StudentDto student, Integer StudentId) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Integer StudentId) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return null;
    }

    @Override
    public void deleteStudent(Integer StudentId) {

    }
    public Student dtoToStudent(StudentDto studentDto){

        Student student=this.modelMapper.map(studentDto,Student.class);
        return student;
    }

    public StudentDto studentToDto(Student student){
        StudentDto studentDto=this.modelMapper.map(student,StudentDto.class);
        return studentDto;
    }
}
