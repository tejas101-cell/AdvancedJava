package com.example.Question2.RestStudentController;


import com.example.Question2.Model.Student;
import com.example.Question2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestStudentController {
    StudentService studentService;

    @Autowired
    public RestStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = studentService.getStudents();
        System.out.println(students);
        return students;
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentbyId(@PathVariable("id") int sid){
        Optional<Student> student = studentService.findById(sid);
        return student;
    }

    @PostMapping("/students")
    public String addedStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student is added";
    }

    @PutMapping("/students")
    public String updatedStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Updated student";
    }

    @DeleteMapping("/students")
    public String deletedStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return "Deleted Student";
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> getStudentsByname(@PathVariable("name") String name){
        List<Student> students = studentService.findByName(name);
        return students;
    }
}
