/*
package com.sms.student.Payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    @Size(min=4,message = "StudentName must be min of 4 characters !!")
    private String name;
    @NotEmpty
    private String FatherName;
    private String ClassName;
    private String City;
    private String about;
}
*/
