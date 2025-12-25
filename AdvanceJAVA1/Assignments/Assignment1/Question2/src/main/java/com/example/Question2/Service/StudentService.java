package com.example.Question2.Service;

import com.example.Question2.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getStudents();
    public Optional<Student> findById(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
    public List<Student> findByName(String name);
}
