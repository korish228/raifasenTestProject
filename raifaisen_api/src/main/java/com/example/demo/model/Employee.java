package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @ManyToMany
    private Set<Project> projects;
    private int numOfDepartments;

    private Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public Employee(String firstName, String lastName, Date dateOfBirth) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.projects = new HashSet<>();
        this.numOfDepartments = projects.size();
    }

    public Employee(String id, String firstName, String lastName, Date dateOfBirth, Set<Project> projects, int numOfDepartments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.projects = projects;
        this.numOfDepartments = numOfDepartments;
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

    public int getNumOfDepartments() {
        return numOfDepartments;
    }

    public void setNumOfDepartments(int numOfDepartments) {
        this.numOfDepartments = numOfDepartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return numOfDepartments == employee.numOfDepartments &&
                Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth) &&
                Objects.equals(projects, employee.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth, projects, numOfDepartments);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", projects=" + projects +
                ", numOfDepartments=" + numOfDepartments +
                '}';
    }
}
