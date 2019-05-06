import { Injectable } from '@angular/core';
import { chapters } from '../entity/chapters';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class ChapterService {

  private readonly baseUrl = 'http://localhost:8080/chapter';

  constructor(private http: HttpClient) { }

  getListChapter(id : number){
    return this.http.get<chapters[]>(this.baseUrl+ '/'+ id +'/list') ;
  }

  getChapterById(id: number){
    return this.http.get<chapters>(this.baseUrl+ '/' + id + '/infor');
  }
}
