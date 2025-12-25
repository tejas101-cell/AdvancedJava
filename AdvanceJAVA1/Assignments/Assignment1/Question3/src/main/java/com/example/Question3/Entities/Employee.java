package com.example.Question3.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ename;
    private String designation;
    private String department;
    private double salary;
    private Date joining_date;

    public Employee(String ename, String designation, String department, double salary, Date joining_date) {
        this.ename = ename;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
        this.joining_date = joining_date;
    }
}
