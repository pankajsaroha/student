package com.sms.student.Service.Impl;

import com.sms.student.Entity.Teacher;
import com.sms.student.Exception.ResourceNotFoundException;
import com.sms.student.Repositories.TeacherRepo;
import com.sms.student.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    public TeacherRepo teacherRepo;
    @Override
    public Teacher createTeacher(Teacher teacher) {
        Teacher Create=teacherRepo.save(teacher);
        return Create;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Integer teacherId) {
        Teacher teacher1=this.teacherRepo.findById(teacherId).orElseThrow(()->new ResourceNotFoundException("Teacher not found"+teacherId));
        teacher1.setTeacherEmail(teacher.getTeacherEmail());
        teacher1.setTeacherName(teacher.getTeacherName());
        teacher1.setSalary(teacher.getSalary());
        Teacher updateTeacher = this.teacherRepo.save(teacher);
        return updateTeacher;
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(()->new ResourceNotFoundException("Teacher not find with id"+teacherId));
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacher(Integer pageNumber, Integer pageSize) {
        //pagination

        Pageable p= (Pageable) PageRequest.of(pageNumber,pageSize);
        Page<Teacher> pagePost = this.teacherRepo.findAll(p);
        List<Teacher> content = pagePost.getContent();

        return content;
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("not found with id " + teacherId));
        this.teacherRepo.delete(teacher);
    }
}
