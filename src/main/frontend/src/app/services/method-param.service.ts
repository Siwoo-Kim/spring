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
}
