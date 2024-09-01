package com.sms.student.Service;

import com.sms.student.Entity.Student;
import com.sms.student.Entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher,Integer teacherId);
    Teacher getTeacherById(Integer teacherId);
    List<Teacher> getAllTeacher(Integer pageNumber,Integer pageSize);
    void deleteTeacher(Integer teacherId);
}
