import { Component, OnInit } from '@angular/core';
import {MethodParamService} from "../../services/method-param.service";

@Component({
  selector: 'app-chap-4n2',
  templateUrl: './chap-4n2.component.html',
  styleUrls: ['./chap-4n2.component.css']
})
export class Chap4n2Component implements OnInit {
  msg1:string;

  constructor(private methodParamService:MethodParamService) {

    setTimeout(()=>{
      this.methodParamService.complex("Guest").subscribe( data => {
        console.log(data);
        this.msg1 = data;
      },);
    },3000);
  }

  ngOnInit() {
  }

  onInputHandler(name:string){
    this.methodParamService.complex(name).subscribe( data => {
      console.log(data);
      this.msg1 = data;
    });
  }

}
