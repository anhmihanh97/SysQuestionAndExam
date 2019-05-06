import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { courseCatalog } from '../../entity/courseCatalog';
import { Course } from '../../entity/course';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { CourseService } from '../../service/course.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  courseFrm: FormGroup;
  courseCatalog: courseCatalog[];
  course: Course;

  public fileVideo: any = File;
  public fileImage: any = File;

  public Editor = ClassicEditor;

  constructor(private location: Location, private courseService: CourseService, private fb: FormBuilder,
    private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.courseFrm = this.fb.group({
      courseName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      courseCatalog: [''],
      tags: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      price: ['', Validators.required],
      title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      description: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      status: ['', Validators.required],
      image: ['', Validators.required],
      video: ['', Validators.required]
    })

    this.loadCatalog();
  }


  loadCatalog() {
    this.courseService.getCourseCatalogList().subscribe(catalog => {
      this.courseCatalog = catalog;
    });
  }

  flag:boolean;
  imgURL: any;
  public messageImg: string;
  onSelectImage(files) {
    if (files.length === 0)
      return;
    this.fileImage = files[0];
    var mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.messageImg = "Only images are supported.";
      this.flag = false;
      return;
    }
    this.flag = true;
    this.messageImg = "";
    var reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.imgURL = reader.result;
    }
  }

  videoURL: any;
  public messageVideo: string;
  onSelectVideo(files) {
    if (files.length === 0)
      return;
    this.fileVideo = files[0];
    var mimeType = files[0].type;
    if (mimeType.match(/video\/*/) == null) {
      this.messageVideo = "Only video are supported.";
      this.flag = false;
      return;
    }
    this.flag = true;
    this.messageVideo = "";
  }


  onSubmit() {
    const value = this.courseFrm.value;

    const formData = new FormData();
    const course: Course = {
      ...value
    }

    formData.append('course', JSON.stringify(course));
    formData.append('fileVideo', this.fileVideo);
    formData.append('fileImage', this.fileImage);
    this.courseService.createCourse(formData)
      .subscribe(() => {
        this.location.back();
      })
  }




  reset(event) {
    event.preventDefault();
    this.courseFrm.reset();
  }

  back() {
    this.location.back();
  }

}
