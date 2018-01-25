import { Injectable } from '@angular/core';
import {Http, RequestOptionsArgs} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class RequestMappingService {
  static url:string ="/rm";

  constructor(private http:Http) { }

  hello():Observable<any>{
    return this.http.get(`${RequestMappingService.url}/hello`)
      .map(response => { console.log(response); console.log(response.json()); return response.json(); });
  }

  helloPost():Observable<any>{
    return this.http.post(
      `${RequestMappingService.url}/hello`,
      null,
      { params : {greeting : 'Hello Spring With Params!'} })
      .map(response => { console.log(response); console.log(response.json()); return response.json(); });
  }

  params(type:string) {
    return this.http.get(
      `${RequestMappingService.url}/params`,{params : {type : type} })
      .map(response => { console.log(response.json()); return response.json() } );
  }

  headers(){
    let headers:any =
      { 'host' : "localhost:8080/frontend",
      'content-type' : 'localhost:8080/frontend' };

    return this.http.get(`${RequestMappingService.url}/headers`,
      {headers : headers }
      ).map(response => response.json() );
  }

}
