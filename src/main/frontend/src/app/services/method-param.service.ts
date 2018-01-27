import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";

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

  threeParams(id:number,name:string,email:string){
    return this.http
      .get(
        `${MethodParamService.url}/three`,
        {params : { id : id , name : name , email : email } }
    )
      .map(response => { console.log(response.json()); return response.json(); })
  }

  getHeaders(){

    let options = new RequestOptions({
      headers : this._getHeaders()
    })

    return this.http
      .get(`${MethodParamService.url}/header`,options).map(response => response.json());
  }

  private _getHeaders():Headers {
    let header = new Headers({
      'Content-Type': 'application/json',
    });

    return header;
  }

}
