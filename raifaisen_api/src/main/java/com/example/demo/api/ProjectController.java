package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> projects(){
        List<Project> projects = projectService.getAllProjects();
        if (projects.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(projects, HttpStatus.OK);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<?> getProject(@PathVariable("id") String id) {

        Project project = this.projectService.findById(id);

        if (project == null){
            return new ResponseEntity("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Project>(project, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> newProject(@RequestBody Project project, UriComponentsBuilder ucBuilder){

        if (projectService.isEmployeeExist(project)) {
            return new ResponseEntity<String>("this project exists",HttpStatus.CONFLICT);

        }

        this.projectService.save(project);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/projects/{id}").buildAndExpand(project.getId()).toUri());
        System.out.println(headers);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") String id, @RequestBody Project project) {

        Project currentProject = this.projectService.findById(id);

        if (currentProject == null) {
            return new ResponseEntity("Unable to upate. Project with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }

        currentProject.setProjectName(project.getProjectName());
        currentProject.setEmployees(project.getEmployees());
        currentProject.setCreated(project.getCreated());

        this.projectService.save(currentProject);

        return new ResponseEntity<Project>(currentProject, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") String id) {

        Project project = this.projectService.findById(id);

        if (!projectService.isEmployeeExist(project)) {
            return new ResponseEntity<String>("this project doesn`t exist ",HttpStatus.CONFLICT);
        }

        this.projectService.delete(project);

        return new ResponseEntity<String>("Project successfully deleted",HttpStatus.OK);

    }


}
