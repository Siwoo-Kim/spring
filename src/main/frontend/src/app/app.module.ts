import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/common/home/home.component';
import {routing} from "./app.routes";
import {HttpModule} from "@angular/http";
import {MatCardModule, MatInputModule, MatListModule} from "@angular/material";
import { Chap4n1Component } from './components/chap-4n1/chap-4n1.component';
import {RequestMappingService} from "./services/request-mapping.service";
import { Chap4n2Component } from './components/chap-4n2/chap-4n2.component';
import {MethodParamService} from "./services/method-param.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    Chap4n1Component,
    Chap4n2Component,

  ],
  imports: [
    HttpModule,
    BrowserModule,
    routing,
    MatCardModule, MatListModule,MatInputModule,
  ],
  providers: [
    RequestMappingService,MethodParamService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
