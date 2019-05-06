import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/entity/User';
import { Role } from 'src/entity/Role';
//import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})

@Injectable()
export class UserService {

  private readonly baseUrl = 'http://localhost:8080/admin/user';
  constructor(private http: HttpClient) { }


  getUser(id: number) {
    return this.http.get<User>(this.baseUrl+ '/' + id + '/infor');
  }

  getRoles() {
    return this.http.get<Role[]>('http://localhost:8080/role/list') ;
  }

  createUser(user: User) {
    return this.http.post(this.baseUrl + '/add', user);
  }

  updateUser(user: Partial<User>) {
    return this.http.put(this.baseUrl+ '/' + user.userId + '/edit',user);
  }

  updateUserRole(user: Partial<User>) {
    return this.http.put(this.baseUrl+ '/' + user.userId + '/update-user',user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id +'/delete' , { responseType: 'text' });
  }

  getUsersList(){
    return this.http.get<User[]>(this.baseUrl+'/list') ;
  }

  searchUser(keyword: string){
    return this.http.get<User[]>(this.baseUrl + '/search/' + keyword );
  }

}
