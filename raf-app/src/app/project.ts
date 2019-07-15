import {Employee} from './employee';

export class Project {

  id: string;
  projectName: string;
  created: Date;
  employees: Employee[] = [];


}
