import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChapterComponent } from './chapter.component';
import { ChapterRoutingModule } from './chapter-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorModule, MatTableModule, MatListModule, MatSortModule } from '@angular/material';

@NgModule({
  declarations: [ChapterComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatListModule,
    MatSortModule,
    ChapterRoutingModule
  ],
  exports: [ChapterComponent]
})
export class ChapterModule { }
