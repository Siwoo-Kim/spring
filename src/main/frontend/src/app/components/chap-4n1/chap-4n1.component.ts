import { Component, OnInit } from '@angular/core';
import {RequestMappingService} from "../../services/request-mapping.service";

@Component({
  selector: 'app-chap-4n1',
  templateUrl: './chap-4n1.component.html',
  styleUrls: ['./chap-4n1.component.css']
})
export class Chap4n1Component implements OnInit {
  greeting:string;
  msg:string;
  msg2:string;
  headers:string;

  constructor(private requestMappingService:RequestMappingService) { }

  ngOnInit() {

   this.requestMappingService.hello().subscribe(
     data =>  { console.log(data); this.greeting = data['greeting']; }
   )

    this.requestMappingService.helloPost().subscribe(
      data=> {console.log(data); this.msg = data['msg']; }
    )

    let type:string="member";
    this.requestMappingService.params(type).subscribe(
      data => { console.log(data); this.msg2 = data['msg2']; }
    );

    this.requestMappingService.headers().subscribe(
      data => this.headers = data
    );

  }

}
