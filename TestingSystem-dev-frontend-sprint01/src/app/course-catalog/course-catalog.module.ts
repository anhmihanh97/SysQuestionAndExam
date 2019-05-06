import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCatalogComponent } from './course-catalog.component';
import { CourseComponent } from './course/course.component';
import { CourseCatalogRoutingModule } from './curse-catalog-routing.module';
import { ChapterModule } from './chapter/chapter.module';
import { MatListModule,MatSelectModule, MatPaginatorModule, MatTableModule, MatSortModule,MatFormFieldModule, MatInputModule } from '@angular/material';
import { LessonModule } from './lesson/lesson.module';
import { UpdateCourseComponent } from './course/update-course/update-course.component';
import { AddCourseCatalogComponent } from './add-course-catalog/add-course-catalog.component';
import { CourseCatalogEditComponent } from './course-catalog-edit/course-catalog-edit.component';
import { PopupDeleteComponent } from './popup-delete/popup-delete.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DetailCourseComponent } from './course/detail-course/detail-course.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { AddCourseComponent } from './course/add-course/add-course.component';
import { LessonComponent } from './lesson/lesson.component';
import { CreateLessonComponent } from './lesson/create-lesson/create-lesson.component';
import { NotifierModule } from 'angular-notifier';
@NgModule({
  declarations: [CourseCatalogComponent, CourseComponent, UpdateCourseComponent,
    DetailCourseComponent, AddCourseComponent,AddCourseCatalogComponent,
    CourseCatalogEditComponent, PopupDeleteComponent,
    LessonComponent,
    CreateLessonComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    CourseCatalogRoutingModule,
    ChapterModule,
    //LessonModule,
    MatPaginatorModule,
    MatTableModule,
    MatListModule,
    MatSortModule,
    FormsModule,
    ReactiveFormsModule,
    CKEditorModule,
    NotifierModule.withConfig({
      position: {
        horizontal: {
          /*
           //* Defines the horizontal position on the screen
           * @type {'left' | 'middle' | 'right'}
           */
          position: 'right',

          /**
           * Defines the horizontal distance to the screen edge (in px)
           //* @type {number}
           */
          distance: 20
        },

        vertical: {
          /**
           * Defines the vertical position on the screen
           //* @type {'top' | 'bottom'}
           */
          position: 'top',

          /**
           * Defines the vertical distance to the screen edge (in px)
           // * @type {number}
           */
          distance: 150,

          /**
           * Defines the vertical gap, existing between multiple notifications (in px)
           //* @type {number}
           */
          gap: 10
        }
      },
      behaviour: {
        /**
         * Defines whether each notification will hide itself automatically after a timeout passes
         //* @type {number | false}
         */
        autoHide: 3000,

        /**
         * Defines what happens when someone clicks on a notification
         //* @type {'hide' | false}
         */
        onClick: 'hide',

        /**
         * Defines what happens when someone hovers over a notification
         //* @type {'pauseAutoHide' | 'resetAutoHide' | false}
         */
        onMouseover: 'pauseAutoHide',

        /**
         * Defines whether the dismiss button is visible or not
         //* @type {boolean}
         */
        showDismissButton: true,

        /**
         * Defines whether multiple notification will be stacked, and how high the stack limit is
         //* @type {number | false}
         */
        stacking: 4
      }
    })
  ],
  exports: [CourseCatalogComponent, CourseComponent, MatPaginatorModule,
    MatTableModule,
    MatListModule,
    LessonComponent,
    MatFormFieldModule,
    CreateLessonComponent]
})
export class CourseCatalogModule { }
