import { Component, OnInit } from '@angular/core';
import { mergeMap, first } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CourseCatalogService } from '../course-catalog.service';
import { CourseCatalog } from '../course-catalog';

@Component({
  selector: 'app-course-catalog-edit',
  templateUrl: './course-catalog-edit.component.html',
  styleUrls: ['./course-catalog-edit.component.css']
})
export class CourseCatalogEditComponent implements OnInit {

  courseCatalogForm: FormGroup;
  courseCatalog: CourseCatalog;
  isChecked: false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRouted: ActivatedRoute,
    private courseCatalogService: CourseCatalogService


  ) { }

  ngOnInit() {

    this.courseCatalogForm = this.formBuilder.group({
      categoryCourseId: [''],
      categoryCourseName: ['', [Validators.required,Validators.minLength(5)]],
      description: ['', [Validators.required,Validators.minLength(6)]],

    });
    this.activatedRouted.paramMap.pipe(
      mergeMap(
        params => {
          const id = params.get('id');
          return this.courseCatalogService.getCourseCatalogFromId(+id);
        }
      )
    ).subscribe(CourseCatalog=>
      {

      this.courseCatalogForm.patchValue(CourseCatalog)
    });
  }

  onSubmit() {
    if( this.courseCatalogForm.value.status === true){
      this.courseCatalogForm.value.status = 1;
    }else{
      this.courseCatalogForm.value.status = 0;
    }
    this.courseCatalogService.updateCourseCatalog(this.courseCatalogForm.value)
    .subscribe( () => {
      alert("Edit courseCatalog success!");
      this.router.navigateByUrl('cms/coursecatalog');
    });
  }

}
