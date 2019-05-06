import { NgModule } from "@angular/core";
import { UnregisterTestingSemesterComponent } from './unregister-testing-semester.component';
import { CommonModule } from '@angular/common';
import { UnregisterTestingSemesterRoutingModule } from './Unregister-testing-semester-routing';
import { RouterModule } from '@angular/router';

@NgModule({
   declarations: [UnregisterTestingSemesterComponent],
   imports: [
      CommonModule,
      UnregisterTestingSemesterRoutingModule,
      RouterModule
   ],
   exports: [UnregisterTestingSemesterComponent]

}) export class UnregisterTestingSemesterModule {

}
