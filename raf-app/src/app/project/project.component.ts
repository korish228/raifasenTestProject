import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import {Project} from '../project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  projects: Project[] = [
    // tslint:disable-next-line:max-line-length
    { id: '1123-543g', projectName: 'Tesla web service ', created: Date,  employees: [] },

    { id: '7gbfgb9', projectName: 'Tesla mobile app for controlling the car', created: Date,  employees: [] },

  ];

  selectedProject: Project;

  constructor() { }

  ngOnInit() {
  }

  onSelect(project: Project): void {
    this.selectedProject = project;
  }


}
