import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/Home/home.component';
import { ProjectsComponent } from './Pages/Projects/projects.component';
import { TaskComponent } from './Pages/Task/task.component';


const routes: Routes = [
  {
    path:'',
    pathMatch: 'full',
    redirectTo: 'hone',
  },
  {
    path: 'home',
    component: HomeComponent
  }, {
    path: 'projects',
    component: ProjectsComponent
  },{
    path: 'tasks',
    component: TaskComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
