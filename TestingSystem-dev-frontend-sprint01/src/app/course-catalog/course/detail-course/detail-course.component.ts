import { Component, OnInit } from '@angular/core';
import { Course } from '../../entity/course';
import { HttpClient } from '@angular/common/http';
import { CourseService } from '../../service/course.service';
import { mergeMap } from 'rxjs/operators';
import {  ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
@Component({
  selector: 'app-detail-course',
  templateUrl: './detail-course.component.html',
  styleUrls: ['./detail-course.component.css']
})
export class DetailCourseComponent implements OnInit {
  course: Course;
  constructor(private location: Location, private activatedRoute: ActivatedRoute, private courseService: CourseService,private http: HttpClient) { }
   url: string;

  ngOnInit() {
    this.loadData();

  }

  back(){
    this.location.back();
  }

  loadData(){
    this.activatedRoute.paramMap.pipe(
      mergeMap(params => {
        const id = Number.parseInt(params.get('id'));
        return this.courseService.getCourseById(id);
      })
    ).subscribe(course => {
      this.course = course;
    });
  }

}
