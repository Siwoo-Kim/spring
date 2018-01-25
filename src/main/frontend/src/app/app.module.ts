import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/common/home/home.component';
import {routing} from "./app.routes";
import {HttpModule} from "@angular/http";
import {MatCardModule, MatListModule} from "@angular/material";
import { Chap4n1Component } from './components/chap-4n1/chap-4n1.component';
import {RequestMappingService} from "./services/request-mapping.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    Chap4n1Component,

  ],
  imports: [
    HttpModule,
    BrowserModule,
    routing,
    MatCardModule, MatListModule,
  ],
  providers: [
    RequestMappingService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
