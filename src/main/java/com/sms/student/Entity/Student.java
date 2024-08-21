package com.sms.student.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity(name="Student_Details")
    //@Table(name="Student_Details")
    @NoArgsConstructor
    @Getter
    @Setter
    public class Student {// this is model class
        @Id
        private int id;
        @Column( nullable = false, length =100 )
        private String name;
        private String FatherName;
        private String City;
        private String about;
       // int n=456;// random integer plugin. alt+r
       // int arr[]={443, 890, 292, 245, 210, 453, 146, 325, 511};

    }

