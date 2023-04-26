import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit{
  taskForm !: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  statusesList: any[] = ['Not yet started', 'In Progress', 'Completed', 'On hold', 'Cancelled'];
  prioritiesList: any[] = ['Immediate', 'Urgent', 'High', 'Medium-high', 'Medium', 'Medium-Low','Low', 'Other (see notes)'];


  statusChange(event: any){
    console.log(event.value);
  }

  priorityChange(event: any){
    console.log(event.value);
  }
}
