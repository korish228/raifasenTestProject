package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findProjectByProjectName(String name);

}
