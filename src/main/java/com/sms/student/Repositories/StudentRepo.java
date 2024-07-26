package com.sms.student.Repositories;

import com.sms.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository <Student,Integer>{
}
