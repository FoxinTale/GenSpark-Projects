import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { demoComponent } from './demo.component';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    demoComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
