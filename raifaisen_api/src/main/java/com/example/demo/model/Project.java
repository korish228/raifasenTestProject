package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Project {

    @Id
    private String id;

    @Column(unique = true)
    private String projectName;
    private Date created;

    @ManyToMany
    private Set<Employee> employees;

    private Project() {
        this.id = UUID.randomUUID().toString();
        this.employees = new HashSet<>();
        this.created = new Date();
    }

    public Project(String projectName) {
        this();
        this.projectName = projectName;
    }

    public Project(String id, String projectName, Date created, Set<Employee> employees) {
        this.id = id;
        this.projectName = projectName;
        this.created = created;
        this.employees = employees;
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

    public Integer getNumOfEmployees() {
        return employees.size();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(created, project.created) &&
                Objects.equals(employees, project.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, created, employees);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", projectName='" + projectName + '\'' +
                ", created=" + created +
                ", employees=" + employees +
                ", numOfEmployees=" + employees.size() +
                '}';
    }
}

