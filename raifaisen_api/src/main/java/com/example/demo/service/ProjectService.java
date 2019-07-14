package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> getAllProjects();

    Project save(Project project);
}
