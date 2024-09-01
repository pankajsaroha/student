package com.sms.student.Service.Impl;

import com.sms.student.Entity.Student;
import com.sms.student.Exception.ResourceNotFoundException;
import com.sms.student.Repositories.StudentRepo;
import com.sms.student.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Student student1 = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));

        student1.setName(student.getName());
        student1.setFatherName(student.getFatherName());
        student1.setCity(student.getCity());
        student1.setAbout(student.getAbout());

        Student updatedStudent = this.studentRepo.save(student);
        return updatedStudent;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student studentById = this.studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student not found with student id:"+studentId));
        return studentById;
    }


    @Override
    public List<Student> getAllStudent(Integer pageNumber, Integer pageSize) {
        Pageable p= (Pageable) PageRequest.of(pageNumber,pageSize);
        Page<Student> pagePost = this.studentRepo.findAll(p);
        List<Student> content=pagePost.getContent();

       // List<Student> collect = all.stream().map(data -> this.Student(data)).collect(Collectors.toList());
        return content;
    }

    // delete student service
    @Override
    public void deleteStudent(Integer studentId) {

        Student student=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found with student id:"+studentId));
        this.studentRepo.delete(student);
    }
}
