package com.example.Question3.RestController;

import com.example.Question3.Entities.Employee;
import com.example.Question3.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestEmployeeController {
    EmployeeService employeeService;

    @Autowired
    public RestEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> gotEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{id}")
    public Optional<Employee> gotEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public String addedEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Employee is added";
    }

    @PutMapping("/employees")
    public String updatedEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Employee is updated";
    }

    @DeleteMapping("/employees/{id}")
    public String deletedEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "Employee is deleted";
    }
}
