import { Component, OnInit, ViewChild } from '@angular/core';
import { Lesson } from '../entity/lesson';
import { FormGroup } from '@angular/forms';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { chapters } from '../entity/chapters';
import { Router, ActivatedRoute } from '@angular/router';
import { LessonService } from '../service/lesson.service';
import {Location} from '@angular/common';
@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {

  lessons: Lesson[] = [];
  keyword: string;
  lessonFrom: FormGroup;
  displayedColumns = ['stt', 'lessonName','status','actions'];
  dataSource: MatTableDataSource<Lesson>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private location: Location,
    private router: Router,
    private lessonService: LessonService,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.activateRoute.paramMap.subscribe(params => {
      const id = params.get('id');
      this.lessonService.getListLesson(+id)
      .subscribe(lessons => {
        this.lessons = lessons;
        this.dataSource = new MatTableDataSource(this.lessons);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });
    });
  }

  deleteLesson(lessonId: number){
    const result = confirm('Do you want to delete the item?');
    if (result) {
      this.lessonService.deleteLesson(lessonId).subscribe(data => {
        console.log(data);
        //this.lessons = data;
        this.dataSource = new MatTableDataSource(this.lessons);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
        //this.router.navigateByUrl('/user/list');
      },
        error => console.log('ERROR: ' + error));
    }
  }


  back(){
    this.location.back();
  }
}
