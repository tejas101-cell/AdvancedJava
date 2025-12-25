package com.example.Question2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int id;

    @Column(name = "sname")
    private String sname;

    @Column(name = "email")
    private String email;

    @Column(name = "course")
    private String course;

    @Column(name = "enrollmentDate")
    private Date enrollmentDate;

    public Student(String sname, String email, String course, Date enrollmentDate) {
        this.sname = sname;
        this.email = email;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }
}
