import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/Home/home.component';
import { CreateCharacterComponent } from './Pages/CreateCharacter/create-character.component';
import { ViewCharactersComponent } from './Pages/ViewCharacters/view-characters.component';
import { CreateJournalComponent } from './Pages/CreateJournal/create-journal.component';
import { OpenJournalComponent } from './Pages/OpenJournal/open-journal.component';
import { ResourcesComponent } from './Pages/Resources/resources.component';
import { AboutComponent } from './Pages/About/about.component';


const routes: Routes = [
  {
    path:'',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'create-character',
    component: CreateCharacterComponent
  },
  {
    path: 'view-characters',
    component: ViewCharactersComponent
  },
  {
    path: 'create-journal',
    component: CreateJournalComponent
  },
  {
    path: 'open-journal',
    component: OpenJournalComponent
  },
  {
    path: 'resources',
    component: ResourcesComponent
  },
  {
    path: 'about',
    component: AboutComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
