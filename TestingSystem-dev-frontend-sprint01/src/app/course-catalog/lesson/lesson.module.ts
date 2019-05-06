import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LessonComponent } from './lesson.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorModule, MatTableModule, MatListModule, MatSortModule } from '@angular/material';
import { CreateLessonComponent } from './create-lesson/create-lesson.component';

@NgModule({
  declarations: [LessonComponent,CreateLessonComponent],
  imports: [
    CommonModule,
    // FormsModule,
    // ReactiveFormsModule,
    // MatPaginatorModule,
    // MatTableModule,
    // MatListModule,
    // MatSortModule
  ],
  exports: [LessonComponent,CreateLessonComponent]
})
export class LessonModule { }
