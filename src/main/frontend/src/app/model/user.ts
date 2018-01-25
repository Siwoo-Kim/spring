import {Address} from "./address";

export class User {

  constructor(
    public id:number,
    public email:string,
    public name:string,
    public address:Address,
    public telephone:string,
    public age:number,
    public point:number,
              ){}
}
