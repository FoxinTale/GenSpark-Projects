import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatTabsModule } from '@angular/material/tabs';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/Home/home.component';
import { CreateCharacterComponent } from './Pages/CreateCharacter/create-character.component';
import { ViewCharactersComponent } from './Pages/ViewCharacters/view-characters.component';
import { CreateJournalComponent } from './Pages/CreateJournal/create-journal.component';
import { OpenJournalComponent } from './Pages/OpenJournal/open-journal.component';
import { AboutComponent } from './Pages/About/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreateCharacterComponent,
    ViewCharactersComponent,
    CreateJournalComponent,
    OpenJournalComponent,
    AboutComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatTabsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
