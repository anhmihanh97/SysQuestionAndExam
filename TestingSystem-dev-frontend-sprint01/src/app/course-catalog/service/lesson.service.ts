import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Lesson } from '../entity/lesson';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

@Injectable()
export class LessonService {

  private readonly baseUrl = 'http://localhost:8080/lesson';

  constructor(private http: HttpClient) { }

  getListLesson(chapterId: number){
    return this.http.get<Lesson[]>(this.baseUrl+ '/'+ chapterId +'/list') ;
  }

  getLessonById(id: number){
    return this.http.get<Lesson>(this.baseUrl+ '/' + id + '/infor');
  }

  createLessson(formdata :FormData, chapterId: number): Observable<any>{

    // const req = new HttpRequest('POST', this.baseUrl + '/' + chapterId + '/add', formdata, {
    // });
    // return this.http.request(req);
    
    return this.http.post(this.baseUrl + '/' + chapterId + '/add', formdata, {
      reportProgress: true,
      responseType: 'text'
    });
  }

  deleteLesson(lessonId: number){
    return this.http.delete(this.baseUrl + '/' + lessonId +'/delete' , { responseType: 'text' });
  }
}
