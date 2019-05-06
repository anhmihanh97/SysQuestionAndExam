import { Component, OnInit } from '@angular/core';
import { CourseCatalog } from '../course-catalog';
import { CourseCatalogService } from '../course-catalog.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-add-course-catalog',
  templateUrl: './add-course-catalog.component.html',
  styleUrls: ['./add-course-catalog.component.css']
})
export class AddCourseCatalogComponent implements OnInit {

  courseCatalogForm: FormGroup;
  isChecked: boolean;
  courseCatalog: CourseCatalog = new CourseCatalog();
  submitted = false;
  constructor(

    private formBuilder: FormBuilder,
    private notifierService: NotifierService,
    private courseCatalogService: CourseCatalogService,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit() {

    this.courseCatalogForm = this.formBuilder.group({

      categoryCourseId: [''],

      categoryCourseName: ['', [Validators.required,Validators.minLength(5)]],

      description: ['', [Validators.required,Validators.minLength(6)]],

    });

  }

  onSubmit(){
    if( this.courseCatalogForm.value.status === true){
      this.courseCatalogForm.value.status = 1;
    }else{
      this.courseCatalogForm.value.status = 0;
    }
    this.courseCatalogService.createCourseCatalog(this.courseCatalogForm.value)
    .subscribe( () => {
      this.router.navigateByUrl('cms/coursecatalog');
    });
  }



}
