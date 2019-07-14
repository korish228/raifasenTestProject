package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> employees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/new")
    public Employee newEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }



}
