import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router';
import { UserTestingComponent } from './user-testing.component';
import { UserTestingResultComponent } from './user-testing-result/user-testing-result.component';

const routes: Routes = [
   {
      path: 'semester/:semesterId/testing/:examId',
      component: UserTestingComponent,
   },
   {
      path: 'semester/:semesterId/result/:examId',
      component: UserTestingResultComponent,
   }

]

@NgModule({

   imports: [
      RouterModule.forChild(routes)
   ]

}) export class UserTestingRoutingModule {

}
