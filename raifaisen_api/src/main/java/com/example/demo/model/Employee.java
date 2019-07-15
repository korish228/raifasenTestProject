package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Email
    @Column(unique = true)
    private String email;
    private Date dateOfBirth;

    @ManyToMany
    private Set<Project> projects;

    private Employee() {
        this.id = UUID.randomUUID().toString();
        this.projects = new HashSet<>();
    }

    public Employee(String firstName, String lastName,String email, Date dateOfBirth) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(String id, String firstName, String lastName,String email, Date dateOfBirth, Set<Project> projects) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Integer getNumProjects() {
        return projects.size();
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", projects=" + projects +
                ", numProjects=" + projects.size() +
                '}';
    }
}
