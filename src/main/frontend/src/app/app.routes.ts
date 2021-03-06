import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/common/home/home.component";
import {Chap4n1Component} from "./components/chap-4n1/chap-4n1.component";
import {Chap4n2Component} from "./components/chap-4n2/chap-4n2.component";

const routes:Routes = [
  {path : '', component:HomeComponent},
  {path: '4_1', component:Chap4n1Component},
  {path: '4_2', component:Chap4n2Component}
];

export const routing = RouterModule.forRoot(routes);
