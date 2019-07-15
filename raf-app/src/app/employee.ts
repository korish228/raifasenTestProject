import {Project} from './project';

export class Employee {

  id: string;
  firstName: string;
  lastName: string;
  email: string;
  dateOfBirth: Date;
  projects: Project[] = [];

}
