import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/common/home/home.component';
import {routing} from "./app.routes";
import {HttpModule} from "@angular/http";
import {MatCardModule, MatListModule} from "@angular/material";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,

  ],
  imports: [
    HttpModule,
    BrowserModule,
    routing,
    MatCardModule, MatListModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
