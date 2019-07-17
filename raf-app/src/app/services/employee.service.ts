import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private BASIC_EMPLOYEE_URL = 'http://localhost:8080/api/employees';


  constructor(private http: HttpClient) {
  }


  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.BASIC_EMPLOYEE_URL);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.BASIC_EMPLOYEE_URL, employee);
  }

}
