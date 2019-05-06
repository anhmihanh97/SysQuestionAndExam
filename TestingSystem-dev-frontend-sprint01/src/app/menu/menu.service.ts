import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { Menu } from './menu';
import { RoleMenu } from 'src/entity/Role';


@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl = 'http://localhost:8080/admin/menu';
  constructor(private http: HttpClient) { }


  getMenusList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/list`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  deleteMenu(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/${id}` + `/delete`, { responseType: 'text' });
  }

  createMenu(menu: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/add`, menu);
  }

  updateMenu(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}`  + `/${id}` + `/edit`, value);
  }

  getMenuFromId(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/${id}` + `/detail` );
  }

  searchMenuByName(name: string){
    if (name === '') {
      return this.getMenusList();
    } else {
      return this.http.get(`${this.baseUrl}` + `/search` + `/${name}`);
    }

  }
}
