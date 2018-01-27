import { Component, OnInit } from '@angular/core';
import {MethodParamService} from "../../services/method-param.service";

class ParamUser{
  constructor(public id,public name,public email){}
}

@Component({
  selector: 'app-chap-4n2',
  templateUrl: './chap-4n2.component.html',
  styleUrls: ['./chap-4n2.component.css']
})
export class Chap4n2Component implements OnInit {
  msg1:string;
  userId:number;
  id:number;

  constructor(private methodParamService:MethodParamService) {

    setTimeout(()=>{
      this.methodParamService.complex("Guest").subscribe( data => {
        console.log(data);
        this.msg1 = data;
      },);
    },3000);

    this.methodParamService.httpServlet();

  }

  ngOnInit() {
  }


  id2:number;
  email2:string;
  name2:string;

  paramUser:ParamUser;

  onSubmitHandler(){
    this.methodParamService.threeParams(this.id2,this.email2,this.name2)
      .subscribe(
        data => this.paramUser = data['paramUser']
      );
  }

  onInputHandler(name:string){
    this.methodParamService.complex(name).subscribe( data => {
      console.log(data);
      this.msg1 = data;
    });
  }

  onClickHandler(){
    this.methodParamService.pathVariable(this.userId).subscribe(
      data => { console.log(data); this.id = data['id']; }
    )
  }

  headers:any;

  onCreateHeaderHandler(){
    this.methodParamService.getHeaders().subscribe(data => {
      console.log(data);
      this.headers = data['header'];
    })
  }
}
