import { Component, OnInit } from '@angular/core';
import { User } from 'src/entity/User';
import { Role } from 'src/entity/Role';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-matrix-userrole',
  templateUrl: './matrix-userrole.component.html',
  styleUrls: ['./matrix-userrole.component.css']
})
export class MatrixUserroleComponent implements OnInit {
  user: User[];
  roles: Role[];


  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.dataRole();
    this.dataUser();
  }
  isCheck(userId: number, roleNamecheck: string) {

    for (let index = 0; index < this.user.length; index++) {
      for (let i = 0; i < this.user[index].roles.length; i++) {
        if (roleNamecheck == this.user[index].roles[i].roleName && this.user[index].userId == userId) {
          return true;
        }
      }
    }
    return false;
  }
  dataRole() {
    this.http
      .get(`http://localhost:8080/role/list`)
      .subscribe((ob: Role[]) => {
        this.roles = ob;
      });
  }
  dataUser() {
    this.http
      .get(`http://localhost:8080/admin/user/list`)
      .subscribe((ob: User[]) => {
        this.user = ob;
      });
  }
  onSelect(userId: number, roleName: string, event,roleId) {
    var flag = false;
    var role: Role = {
      roleId: roleId,
      roleName: roleName,
      users: null,
    }
    var data: User = {
      userId: userId,
      roles:[role],
      fullName: null,
      email: null,
      mobile: null,
      password: null,
      status: null
    };

    if (event.target.checked === true) {
      flag = true;
      if(flag){
        data.status = 1;
      }

      this.http.put('http://localhost:8080/admin/user/update-user',data).subscribe(() => {
        console.log("add ok");
      });
    }else{
      this.http.put('http://localhost:8080/admin/user/update-user',data).subscribe(() => {
        console.log("add ok");
      });
    }
  }

}




