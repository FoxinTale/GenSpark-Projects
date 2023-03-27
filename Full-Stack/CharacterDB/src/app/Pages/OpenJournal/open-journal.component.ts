import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms'; 
import { LoginModel } from 'src/app/Models/login.model';
import { UserModel } from 'src/app/Models/user.model';
import { ApiService } from 'src/app/api/api.service';

@Component({
  selector: 'app-open-journal',
  templateUrl: './open-journal.component.html',
  styleUrls: ['./open-journal.component.css']
})


export class OpenJournalComponent implements OnInit{
  loginForm !: FormGroup;
  userData: LoginModel = new LoginModel();
  users: UserModel = new UserModel();
  userCount: number= 0;
  userNames: string[] = [];
  userEmails: string[] = [];
  userPasswords: string[] = [];

  constructor(private formBuilder: FormBuilder, private api : ApiService) {}


  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      userName: [''],
      userPassword: ['']
    })
    this.getUsersData();
  }

  getUsersData(){
    this.api.getUser().subscribe(result=>{
      this.users = result;
      this.userCount = result.length;

      for( var i = 0; i < this.userCount; i++){
        this.userNames.push(result[i].userName);
        this.userEmails.push(result[i].userEmail);
        this.userPasswords.push(result[i].userPassword);
      }
    })
  }

  // We really should be doing this stuff server-side since, security-wise we should never trust the user's input,
  // and we know client side content can be modified...but again, time constraints led to this happening.
  doLogin(){
    this.getUsersData();
    this.userData.userName = this.loginForm.value.userName;
    this.userData.userPassword = this.loginForm.value.userPassword;

    console.log(this.userData.userName);
    console.log(this.userData.userPassword);
    console.log(this.userNames);
    console.log(this.users);

    (<HTMLInputElement>document.getElementById("errors")).value = "";

    if(this.userData.userName == "" || this.userData.userPassword == ""){ 
      (<HTMLInputElement>document.getElementById("errors")).value = "Username or Password cannot be empty!";

    } else {
      if(this.userNames.includes(this.userData.userName) || this.userEmails.includes(this.userData.userName)){
        console.log(this.userNames.indexOf(this.userData.userName));
  
        if(this.userPasswords[this.userNames.indexOf(this.userData.userName)] == this.userData.userPassword){
          console.log("Passwords match");
          //We do log-in stuff here.
          (<HTMLInputElement>document.getElementById("user-display")).innerHTML = this.userData.userName;
          (<HTMLInputElement>document.getElementById("logoutButton")).style.display = 'block';

          this.loginForm.reset();
        } else {
          (<HTMLInputElement>document.getElementById("errors")).value = "Passwords do not match";
        }
      } else {
        (<HTMLInputElement>document.getElementById("errors")).value = "No known username or email matching that found.";
      }
    }
  }
}
