import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit{
  projectForm !: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  statusesList: any[] = ['Completed', 'Active', 'On hold', 'To start', 'Cancelled'];

  ngOnInit(): void {

  }

  onChange(event: any){
    console.log(event.value);
  }
}
