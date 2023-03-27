import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/api/api.service';
import { UserModel } from 'src/app/Models/user.model';

@Component({
  selector: 'app-create-journal',
  templateUrl: './create-journal.component.html',
  styleUrls: ['./create-journal.component.css']
})
export class CreateJournalComponent implements OnInit{
  formValue !: FormGroup;
  user: UserModel = new UserModel();
  userDataArray !: any;
  
  constructor(private formBuilder: FormBuilder, private api : ApiService) {}

  ngOnInit(): void{
    this.formValue = this.formBuilder.group({
      userName: [''],
      userPassword: [''],
      userEmail: [''],
      userIsAdmin: false
    })
    this.getUserData();
  }

  getUserData(){
    this.api.getUser().subscribe(result=>{
      this.userDataArray = result;
    })
  }

  postUserData(){
    this.user.userName = this.formValue.value.userName;
    this.user.userPassword = this.formValue.value.userPassword;
    this.user.userEmail = this.formValue.value.userEmail;

    this.api.postUser(this.user).subscribe(result=>{
      console.log(result);
      this.formValue.reset();
    },
    err=>{
      alert("Great Googly-Moogly it's all gone to sh*t!.");
    })
  }

  checkUserInfo(){
    let passwordOne :string  = (<HTMLInputElement>document.getElementById("pass")).value;
    let passwordTwo :string = (<HTMLInputElement>document.getElementById("pass2")).value;
    let emailOne: string = (<HTMLInputElement>document.getElementById("email")).value;
    let emailTwo: string = (<HTMLInputElement>document.getElementById("email2")).value;

    let emailReg = new RegExp(/^[^\s@]+@[^\s@]+\.[^\s@]+$/);

    let validEmail: boolean = false;
    let passwordValid: boolean = false;
    

    if(emailOne == "" || emailTwo == "" || passwordOne == "" || passwordTwo == ""){
      (<HTMLInputElement>document.getElementById("infobox")).value = "None of these boxes can be empty.";
    } else{
      if(emailReg.test(emailOne)){
        if(emailReg.test(emailTwo)){
          if(emailOne == emailTwo){
            (<HTMLInputElement>document.getElementById("infobox")).value = "";
              validEmail = true;
          } else {
            (<HTMLInputElement>document.getElementById("infobox")).value = "E-mails are not equal to each other.";
          }
        } else {
          (<HTMLInputElement>document.getElementById("infobox")).value = "Second e-mail is not a valid e-mail.";
        }
      } else {
        (<HTMLInputElement>document.getElementById("infobox")).value = "First e-mail is not a valid e-mail.";
      }


      if(passwordOne == passwordTwo){
        (<HTMLInputElement>document.getElementById("infobox")).value = "";
        passwordValid = true;
      } else {
        (<HTMLInputElement>document.getElementById("infobox")).value = "Passwords are not equal";
      }    
    }

    
    if(validEmail && passwordValid){
      console.log("Email and passwords valid, adding user.");
      this.postUserData();
    }
  }
  


  deleteUserData(row:any){
    this.api.deleteUser(row.id).subscribe(result =>{
      window.location.reload();
      alert("Deletion successful.");
    })
  }
}
