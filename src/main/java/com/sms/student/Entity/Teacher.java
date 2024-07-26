package com.sms.student.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    @Column(nullable = false, length =100 )
    private String teacherName;
    private String teacherEmail;
    private String specialization;
    private String salary;

}
