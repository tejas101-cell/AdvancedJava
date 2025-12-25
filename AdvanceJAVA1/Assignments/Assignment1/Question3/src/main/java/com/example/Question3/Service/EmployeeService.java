package com.example.Question3.Service;

import com.example.Question3.Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public void addEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(Integer id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Integer id);
}
