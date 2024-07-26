package com.sms.student.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
    @NoArgsConstructor
    @Getter
    @Setter
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @Column( nullable = false, length =100 )
        private String name;
        private String FatherName;
        private String ClassName;
        private String City;
        private String about;



    }

