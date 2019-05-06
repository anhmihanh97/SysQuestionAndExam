import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SemesterExamRoutingModule } from './semester-exam-routing.module';

import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import { SemesterModule } from './semester/semester.module';
@NgModule({
   declarations: [],

   imports: [
      CommonModule,
      BrowserAnimationsModule,
      SemesterExamRoutingModule,
      SemesterModule,
      BsDatepickerModule.forRoot()
   ],
   exports: []

})
export class SemesterExamModule { }
