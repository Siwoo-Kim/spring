import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {parseHttpResponse} from "selenium-webdriver/http";

@Injectable()
export class MethodParamService {
  static url:string = "/mp";

  constructor(private http:Http) { }

  complex(name:string) :Observable<any> {
    return this.http.get(`${MethodParamService.url}/complex`,
      {params: {name:name}})
      .map(response => response.json());
  }

  httpServlet(){
    this.http.get(`${MethodParamService.url}/httpServlet`,
      {params: {param1 : 'Hey!',param2 : 'Good!'}})
      .subscribe(data => console.log(data) );
  }

  pathVariable(id:number){
    return this.http.get(`${MethodParamService.url}/path/${id}`)
      .map(response => response.json());
  }
}
