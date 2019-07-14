package com.example.demo.api;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> employees(){
        List<Employee> list = employeeService.getAllEmployees();
        if (list.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") String id) {

        Employee employee = this.employeeService.findById(id);

        if (employee == null){
            return new ResponseEntity("User with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }
//
//    SHOULD FIX
//

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){

        if (employeeService.isEmployeeExist(employee)) {
            return new ResponseEntity<String>("this user exists",HttpStatus.CONFLICT);

        }

        employeeService.save(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(employee.getId()).toUri());
        System.out.println(headers);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

//
//
//

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {

        Employee currentEmployee= this.employeeService.findById(id);

        if (currentEmployee == null) {
            return new ResponseEntity("Unable to upate. User with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }

        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setDateOfBirth(employee.getDateOfBirth());
        currentEmployee.setProjects(employee.getProjects());

        this.employeeService.save(currentEmployee);

        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
//
//        Employee employee = this.employeeService.findById(id);
//
//        if (!employeeService.isEmployeeExist(employee)) {
//            return new ResponseEntity<String>("this user doesn`t exist earlier",HttpStatus.CONFLICT);
//        }
//
//        this.employeeService.delete(employee);
//
//        return new ResponseEntity<String>("this user doesn`t exist earlier",HttpStatus.CONFLICT);
//
//    }



}
