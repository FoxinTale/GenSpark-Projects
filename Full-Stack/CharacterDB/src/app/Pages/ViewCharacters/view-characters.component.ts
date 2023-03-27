import { Component, OnInit } from '@angular/core';
import { CreateCharacterComponent } from '../CreateCharacter/create-character.component';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-view-characters',
  templateUrl: './view-characters.component.html',
  styleUrls: ['./view-characters.component.css']
})
export class ViewCharactersComponent extends CreateCharacterComponent implements OnInit {
  
}
