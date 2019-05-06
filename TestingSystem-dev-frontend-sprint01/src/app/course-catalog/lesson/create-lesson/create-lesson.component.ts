import { Component, OnInit } from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LessonService } from '../../service/lesson.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Test } from 'src/app/semester-exam/semester/detail/test-result/test.interface';
import { HttpClient } from '@angular/common/http';
import { Lesson } from '../../entity/lesson';

@Component({
  selector: 'app-create-lesson',
  templateUrl: './create-lesson.component.html',
  styleUrls: ['./create-lesson.component.css']
})
export class CreateLessonComponent implements OnInit {

  lessonForm: FormGroup;
  tests: Test[] = [];
  public Editor = ClassicEditor;
  public fileVideo: any = File;
  public fileAudio: any = File;
  public fileDocument: any = File;

  constructor(
    private lessonService: LessonService,
    private formBuilder: FormBuilder,
    private router: Router,
    private http: HttpClient,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit() {
   
    this.http.get<Test[]>('http://localhost:8080/test/listTest').subscribe(tests => {
        this.tests = tests;
    })
    this.lessonForm = this.formBuilder.group({
      lessonName: ['',Validators.required],
      content: ['',Validators.required],
      condition: ['',Validators.required],
      tags: ['',Validators.required],
      description: ['',Validators.required],
      status:[''],
      testId: ['']
    })
  }

  onSelectVideo(event){
    const filevideo = event.target.files[0];
    console.log(filevideo);
    this.fileVideo = filevideo;
  }

  onSelectAudio(event){
    const fileaudio = event.target.files[0];
    this.fileAudio = fileaudio;
    console.log(fileaudio);
  }

  onSelectDocument(event){
    const filedocument = event.target.files[0];
    this.fileDocument = filedocument;
    console.log(filedocument);
  }

  onSubmit(){
    this.activateRoute.paramMap.subscribe(params => {
      const chapterId = params.get('chapterId');
      const lesson = this.lessonForm.value;
      const testId =  this.lessonForm.value.testId;
      const formData = new FormData();
      formData.append('lesson', JSON.stringify(lesson));
      formData.append('testId', JSON.stringify(+testId));
      formData.append('fileVideo',this.fileVideo);
      formData.append('fileDocument',this.fileDocument);
      formData.append('fileAudio',this.fileAudio);

      this.lessonService.createLessson(formData,+chapterId)
      .subscribe( () => {
        alert("Create user success!");
        //this.router.navigateByUrl('coursecatalog/course/:id/chapter/:id/lesson');
      });
    });
  }

}
