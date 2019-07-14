package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public boolean isEmployeeExist(Employee employee) {
        Employee employee1 = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if (employee1 != null){
            return true;
        }

        return false;
    }
    @Override
    public void delete(Employee employee) {
        this.employeeRepository.deleteById(employee.getId());
    }
}
