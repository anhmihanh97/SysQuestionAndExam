import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CourseService } from '../course-catalog/service/course.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  totalCourse: string;
  constructor( private courseService: CourseService,
    private http: HttpClient,) { }

  ngOnInit() {
    this.courseService.countCouurse().subscribe(toal => {
      this.totalCourse = toal;
    })
  }

}
