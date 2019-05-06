import { Component, OnInit } from '@angular/core';
import { courseCatalog } from '../../entity/courseCatalog';
import { CourseService } from '../../service/course.service';
import { HttpClient } from '@angular/common/http';
import { Course } from '../../entity/course';
import { ActivatedRoute, Router } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { Location } from '@angular/common';
@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {
  courseFrm: FormGroup;
  courseCatalog: courseCatalog[] = [];
  course: Course;
  courseID: number;
  flag: boolean;
  imgURL: any;
  public messageVideo: string;
  public messageImg: string;
  public fileVideo: any = File;
  public fileImage: any = File;

  public Editor = ClassicEditor;
  constructor(private location: Location, private activatedRoute: ActivatedRoute, private courseService: CourseService, private fb: FormBuilder,
    private http: HttpClient, private router: Router) { }



  ngOnInit() {
    this.courseFrm = this.fb.group({
      courseName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      courseCatalog: [''],
      tags: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      price: ['', Validators.required],
      title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      description: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(225)]],
      status: [''],
      image: [''],
      video: ['']
    })

    this.loadCatalog();

    this.activatedRoute.paramMap.pipe(
      mergeMap(params => {
        const id = Number.parseInt(params.get('id'));
        this.courseID = id;
        return this.courseService.getCourseById(id);
      })
    ).subscribe(course => {
      this.course = course;
      this.imgURL = "http://localhost:8080/files/" + course.image;
      this.courseFrm.patchValue(
        {
          courseName: course.courseName,
          courseCatalog: course.courseCatalog.categoryCourseId,
          tags: course.tags,
          price: course.price,
          status: course.status,
          title: course.title,
          description: course.description
        }
      );
    });

  }

  loadCatalog() {
    this.courseService.getCourseCatalogList().subscribe(catalog => {
      this.courseCatalog = catalog;
    });
  }




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
      console.log(this.imgURL);
    }
  }


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
    const categoryCourseId = value.courseCatalog;
    var courseCatalog: courseCatalog;
    if (categoryCourseId !== '') {
      courseCatalog = this.courseCatalog.find(v => v.categoryCourseId = categoryCourseId);
    } else {
      courseCatalog = this.course.courseCatalog;
    }
    const formData = new FormData();
    const course: Course = {
      courseId: this.courseID,
      ...value
    }
    course.courseCatalog = courseCatalog;
    formData.append('course', JSON.stringify(course));
    formData.append('fileVideo', this.fileVideo);
    formData.append('fileImage', this.fileImage);


    this.courseService.updateCourse(formData)
      .subscribe(() => {
        this.location.back();
      })
  }


  reset(event) {
    event.preventDefault();
    this.flag = true;
    this.messageVideo = "";
    this.messageImg = "";
    this.courseFrm.reset();
    this.courseFrm.patchValue(
      {
        courseName: this.course.courseName,
        courseCatalog: this.course.courseCatalog.categoryCourseId,
        tags: this.course.tags,
        price: this.course.price,
        status: this.course.status,
        title: this.course.title,
        description: this.course.description,

      }
    );
    this.imgURL = "http://localhost:8080/files/" + this.course.image;
  }

  back() {
    this.location.back();
  }

}
