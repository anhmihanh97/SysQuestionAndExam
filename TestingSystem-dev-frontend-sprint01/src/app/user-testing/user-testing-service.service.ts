import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
   providedIn: 'root'
})
export class UserTestingServiceService {
   readonly httpOptions = {
      headers: new HttpHeaders({
         'Content-Type': 'application/json',
         'Authorization': 'my-auth-token'
      })
   };

   constructor(private http: HttpClient) {

   }
   getExam(semesterId: string, testId: string): Observable<any> {
      return this.http.get(`http://localhost:8080/test/semesters/${semesterId}/tests/${testId}`);
   }

   submitResultTest(userId: number, testId: number, data: any): Observable<any> {
      return this.http.post<any>(`http://localhost:8080/users/${userId}/tests/${testId}`, JSON.stringify(data), this.httpOptions)
         .pipe(
         );
   }

   getResultTest(userId: number, semesterId: string, testId: string): Observable<any> {
      return this.http.get(`http://localhost:8080/users/${userId}/semesters/${semesterId}/result/${testId}`);
   }
}
