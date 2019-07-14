package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    Employee save(Employee employee);

    Employee findById(String id);

    boolean isEmployeeExist(Employee employee);

    void delete(Employee employee);
}
