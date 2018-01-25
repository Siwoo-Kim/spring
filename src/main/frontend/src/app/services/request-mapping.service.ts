import { Injectable } from '@angular/core';
import {Http, RequestOptionsArgs} from "@angular/http";
import {Observable} from "rxjs/Observable";

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

}
