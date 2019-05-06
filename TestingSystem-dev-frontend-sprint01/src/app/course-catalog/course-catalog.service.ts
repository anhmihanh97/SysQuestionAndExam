import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CourseCatalog } from './course-catalog';


@Injectable({
  providedIn: 'root'
})
export class CourseCatalogService {

  private baseUrl = 'http://localhost:8080/admin/courseCatalog';
  getCourseCatalogs: any;

  constructor(private http: HttpClient) { }

  getCourseCatalogsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/list`);
  }
  
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  deleteCourseCatalog(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/${id}` + `/delete`, { responseType: 'text' });
  }

  // deleteCourseCatalog(id: number): Observable<any> {
  //   return this.http.delete(this.baseUrl + '/' + id +'/delete' , { responseType: 'text' });
  // }

  createCourseCatalog(courseCatalog: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/add`, courseCatalog);
  }

  // updateCourseCatalog(id: number, value: any): Observable<Object> {
  //   return this.http.put(`${this.baseUrl}`  + `/${id}` + `/edit`, value);
  // }
  updateCourseCatalog(courseCatalog: Partial<CourseCatalog>) {
    return this.http.put(this.baseUrl+ '/' + courseCatalog.categoryCourseId + '/edit',courseCatalog);
  }

  getCourseCatalogFromId(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/${id}` + `/detail` );
  }

  searchCourseCatalogByName(name: string): Observable<any> {
    if (name === '') {
      return this.getCourseCatalogsList();
    } else {
      return this.http.get(`${this.baseUrl}` + `/search` + `/${name}`);
    }

  }
}
