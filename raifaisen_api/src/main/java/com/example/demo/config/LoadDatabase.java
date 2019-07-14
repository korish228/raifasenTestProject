package com.example.demo.config;

import com.example.demo.api.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.logging.Logger;

@Configuration
class LoadDatabase {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Bean
    void initDatabase() {

        Employee employee1 =   this.employeeRepository.save(new Employee("Dmytrro ", "Korish", new Date()));

        Employee employee2 =   this.employeeRepository.save(new Employee("Bilbo ", "Baggins", new Date()));

        Employee employee3 =   this.employeeRepository.save(new Employee("Danil ", "Hotsyk", new Date()));

        Project project1 =     this.projectRepository.save(new Project("Developing of new Social Media"));
    }
}