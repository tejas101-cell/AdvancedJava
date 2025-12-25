package com.example.Question2.Service;


import com.example.Question2.Model.Student;
import com.example.Question2.Repository.StudentRepository;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
        return students;
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = studentRepository.findAll();
        List<Student> students1 = null;
        for(Student student : students){
            if(student.getSname().contains(name)){
                students1.add(student);
            }
        }
        return students1;
    }

}
