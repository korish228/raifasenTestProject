import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[] = [
    // tslint:disable-next-line:max-line-length
    { id: '1123-543g', firstName: 'Dima', lastName: 'Korishkkk', email: 'ldfljvidfbfbn@gmail.com', dateOfBirth: Date, projects: [] },
    { id: '1bfgbfg-g', firstName: 'Danyaa', lastName: 'Gootys', email: 'dfbdbg@gmail.com', dateOfBirth: Date, projects: [] },
    { id: 'f-5g-4gtg', firstName: 'Kate', lastName: 'FFvidfdff', email: 'dfvfvdvf@gmail.com', dateOfBirth: Date, projects: [] }

  ];

  selectedEmployees: Employee;

  constructor() { }

  ngOnInit() {
  }

  onSelect(employee: Employee): void {
    this.selectedEmployees = employee;
    // alert(employee.email);
  }

  deleteEmployee(employee: Employee) {
    // this.selectedEmployees = employee;
    // employee
    alert('delete');

  }
}

