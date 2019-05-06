import { NgModule } from "@angular/core";
import { CommonModule } from '@angular/common';
import { UserTestingSemesterRoutingModule } from './user-testing-semester-routing.module';
import { DetailComponent } from './detail/detail.component';
import { RouterModule } from '@angular/router';

@NgModule({
   imports: [
      CommonModule,
      UserTestingSemesterRoutingModule,
      RouterModule
   ],
   declarations: [DetailComponent],
   exports: [DetailComponent]
}) export class UserTestingSemesterModule {

}
