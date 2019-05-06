import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable} from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private baseUrl = 'http://localhost:8080/courses';
  constructor(private http: HttpClient) { }

  getCourseList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/list`);
  }

  getCourseById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/${id}`);
  }

  getCourse(p: string, s: string): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/pagination?page=${p}&size=${s}`).pipe(
      tap()
    )
  }

  countCouurse():Observable<any> {
    return this.http.get(`${this.baseUrl}`+  `/sum`);
  }

  sumSearchCourse(content: string):Observable<any> {
    return this.http.get(`${this.baseUrl}`+  `/sum?SearchcontentSearch=${content}`);
  }

  getSearchCourse(content: string,p: string, s: string): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/search-by-content?contentSearch=${content}&page=${p}&size=${s}`).pipe(
      tap()
    )
  }

  sumCourse():Observable<any> {
    return this.http.get(`${this.baseUrl}`+  `/sum`);
  }

  getCourseCatalogList(): Observable<any> {
    return this.http.get(`http://localhost:8080/admin/courseCatalog/course-catalog/list`);
  }

  updateCourse(formdata :FormData): Observable<any>{
    return this.http.put(this.baseUrl + '/edit', formdata);
  }

  createCourse(formdata :FormData): Observable<any>{
    return this.http.post(this.baseUrl + '/add', formdata);
  }
  deleteCourse(courseID : number): Observable<any>{
    return this.http.delete(`http://localhost:8080/courses/delete/${courseID}`)
  }


  filterCourse(idCatalog: number,p: string, s: string): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/filterCatalog?idCatalog=${idCatalog}&page=${p}&size=${s}`).pipe(
      tap()
    )
  }
  sumfilterCourse(idCatalog: number):Observable<any> {
    return this.http.get(`${this.baseUrl}`+  `/countFilter?idCatalog=${idCatalog}`);
  }
}
