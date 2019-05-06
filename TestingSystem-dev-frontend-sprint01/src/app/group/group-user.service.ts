import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { GroupUser } from './group-user';

@Injectable({
  providedIn: 'root'
})
export class GroupUserService {

  private baseUrl = 'http://localhost:8080/admin/group';
  constructor(private http: HttpClient) { }

  getGroupUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/list`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  deleteGroupUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/${id}` + `/delete` , { responseType: 'text' });
  }

  createUserGroup(groupUser: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/add`, groupUser);
  }

  updateUserGroup(id: number, value: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/${id}`+ `/edit`, value);
  }

  // update groupId of temp table
  updateUserGroupId(id: number, value: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/edit` + `/${id}`, value);
  }

  getGroupUserFromId(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/${id}` + `/detail` );
  }

  getUsersFromGroupId(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/detail` + `/${id}` + `/users`);
  }

  addUserIntoGroup(group_id: number, user_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/add` + `/${group_id}` + `/users` + `/${user_id}`);
  }

  deleteUserFromGroup(group_id: number, user_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/delete` + `/${group_id}` + `/users` + `/${user_id}`);
  }

  searchGroupUserByName(name: string): Observable<any> {
    if (name === '') {
      return this.getGroupUsersList();
    } else {
      return this.http.get(`${this.baseUrl}` + `/search` + `/${name}`);
    }
  }

}
