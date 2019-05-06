import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router';
import { UnregisterTestingSemesterComponent } from './unregister-testing-semester.component';

const routes: Routes = [
  //  {
  //     path: 'guest/semesters/:semesterCode',
  //     component: UnregisterTestingSemesterComponent
  //  }
]
@NgModule({
   imports: [
      RouterModule.forChild(routes)
   ],
   exports: [
      RouterModule
   ]
}) export class UnregisterTestingSemesterRoutingModule {

}
