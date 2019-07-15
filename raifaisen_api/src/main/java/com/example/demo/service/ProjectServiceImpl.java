package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findById(String id) {
        return this.projectRepository.findById(id).get();
    }

    @Override
    public boolean isEmployeeExist(Project project) {
        Project project1 = this.projectRepository.findProjectByProjectName(project.getProjectName());

        if (project1 != null){
            return true;
        }

        return false;
    }

    @Override
    public void delete(Project project) {
        this.projectRepository.deleteById(project.getId());
    }
}
