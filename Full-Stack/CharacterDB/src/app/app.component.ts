import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  title = 'charDB';

  logout(){
    (<HTMLInputElement>document.getElementById("user-display")).innerHTML = "";
    (<HTMLInputElement>document.getElementById("logoutButton")).style.display = 'none';
  }
}
