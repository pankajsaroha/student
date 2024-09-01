package com.sms.student.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
        @NotEmpty
        @Size(min=4,message="Username must be min of 4 characters !!")
        private String name;
        @NotEmpty
        private String FatherName;
        @NotEmpty
        private String City;
        @NotEmpty
        private String about;
       // int n=456;// random integer plugin. alt+r
       // int arr[]={443, 890, 292, 245, 210, 453, 146, 325, 511};

    }

