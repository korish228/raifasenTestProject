package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Project {

    @Id
    private String id;
    private String projectName;
    private Date created;

    @ManyToMany
    private Set<Employee> employees;
    private int numOfEmployees;

    private Project() {
        this.id = UUID.randomUUID().toString();
    }

    public Project(String projectName) {
        this();
        this.created = new Date();
        this.projectName = projectName;
        this.employees = new HashSet<>();
        this.numOfEmployees = employees.size();
    }

    public Project(String id, String projectName, Date created, Set<Employee> employees, int numOfEmployees) {
        this.id = id;
        this.projectName = projectName;
        this.created = created;
        this.employees = employees;
        this.numOfEmployees = numOfEmployees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return numOfEmployees == project.numOfEmployees &&
                Objects.equals(id, project.id) &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(created, project.created) &&
                Objects.equals(employees, project.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, created, employees, numOfEmployees);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", projectName='" + projectName + '\'' +
                ", created=" + created +
                ", employees=" + employees +
                ", numOfEmployees=" + numOfEmployees +
                '}';
    }
}

