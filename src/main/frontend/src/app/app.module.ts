import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/common/home/home.component';
import {routing} from "./app.routes";
import {HttpModule} from "@angular/http";
import {MatButtonModule, MatCardModule, MatExpansionModule, MatInputModule, MatListModule} from "@angular/material";
import { Chap4n1Component } from './components/chap-4n1/chap-4n1.component';
import {RequestMappingService} from "./services/request-mapping.service";
import { Chap4n2Component } from './components/chap-4n2/chap-4n2.component';
import {MethodParamService} from "./services/method-param.service";
import {FormsModule} from "@angular/forms";
import { Chap4n3Component } from './components/chap-4n3/chap-4n3.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    Chap4n1Component,
    Chap4n2Component,
    Chap4n3Component,

  ],
  imports: [
    HttpModule,
    BrowserModule,
    routing, FormsModule,
    MatCardModule, MatListModule
    ,MatInputModule,MatButtonModule,MatExpansionModule,
  ],
  providers: [
    RequestMappingService,MethodParamService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
