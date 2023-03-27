import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/api/api.service';
import { characterModel } from 'src/app/Models/character.model';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-create-character',
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.css']
})


export class CreateCharacterComponent implements OnInit{
  formValue !: FormGroup;
  character: characterModel = new characterModel();
  charDataArray !: any;

  constructor(private formBuilder: FormBuilder, private api : ApiService, private route: ActivatedRoute, private router: Router) {}
  charID: number = 0;

  ngOnInit(): void{
    this.formValue = this.formBuilder.group({
      charFullName: [''],
      charShortName: [''],
      charShortDesc: [''],
      charAge: [''],
      charGender: [''],
      charSpecies: ['']
    })
    this.getCharacterData();
  }


  getCharacterData(){
    this.api.getCharacter().subscribe(result=>{
      this.charDataArray = result
    })  
  }

  addCharacter(character: CharacterData){
    const headers = { 'content-type': 'application/json'}
    const body = JSON.stringify(character);
    console.log(body);
  }

  editCharacterInfo(char:any){
    this.charID = char.characterID;
    this.api.getCharacterByID(char.characterID).subscribe(result =>{
      document.getElementById('displayInfo')!.style.display = "block";
      
      (<HTMLInputElement>document.getElementById("charname")).value = char.characterName;
      (<HTMLInputElement>document.getElementById("charalias")).value = char.shortName;
      (<HTMLInputElement>document.getElementById("charshortdesc")).value = char.characterDesc;
      (<HTMLInputElement>document.getElementById("charage")).value = char.age;
      (<HTMLInputElement>document.getElementById("chargender")).value = char.gender;
      (<HTMLInputElement>document.getElementById("charspecies")).value = char.species;
      
    })
  }

  postCharacterData(){
    this.character.characterName = this.formValue.value.charFullName;
    this.character.shortName = this.formValue.value.charShortName;
    this.character.characterDesc = this.formValue.value.charShortDesc;
    this.character.age = this.formValue.value.charAge;
    this.character.gender = this.formValue.value.charGender;
    this.character.species = this.formValue.value.charSpecies;

    this.api.postCharacter(this.character).subscribe(result=>{
      this.formValue.reset();
      alert("Character added successfully!");
    },
    err=>{
      alert("Great Googly-Moogly it's all gone to sh*t!.");
    })
  }

  updateCharacterData(){
    this.character.characterID = this.charID;
    this.character.characterName = (<HTMLInputElement>document.getElementById("charname")).value;
    this.character.shortName = (<HTMLInputElement>document.getElementById("charalias")).value;
    this.character.characterDesc = (<HTMLInputElement>document.getElementById("charshortdesc")).value;
    this.character.age = (<HTMLInputElement>document.getElementById("charage")).value;
    this.character.gender = (<HTMLInputElement>document.getElementById("chargender")).value;
    this.character.species = (<HTMLInputElement>document.getElementById("charspecies")).value;

    console.log(this.character);
    this.api.updateCharacter(this.character).subscribe(result=>{
      console.log(result);
      this.formValue.reset();
      alert("Information successfully updated.");
      window.location.reload();
    },
    err=>{
      alert("Great Googly-Moogly it's all gone to sh*t!.");
    })
  }

  deleteCharacter(row:any){
    console.log(row.characterID);

    this.api.deleteCharacter(row.characterID).subscribe(result=>{
      alert("Delete successful.");
    }, err =>{
      console.log(err);
      this.router.navigate(['/view-characters']);
    })
  }
  
}
