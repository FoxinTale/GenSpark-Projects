import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  title = 'ClientProjectManagement';
  logout(){
    (<HTMLInputElement>document.getElementById("user-display")).innerHTML = "";
    (<HTMLInputElement>document.getElementById("logoutButton")).style.display = 'none';
  }
}
