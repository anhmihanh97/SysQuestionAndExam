import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/menu/menu.service';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/menu/menu';
import { Role, RoleMenu, Menus } from 'src/entity/Role';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-matrix-rolemenu',
  templateUrl: './matrix-rolemenu.component.html',
  styleUrls: ['./matrix-rolemenu.component.css']
})
export class MatrixRolemenuComponent implements OnInit {
  menus: Observable<Menu[]>;
  roles: Role[];
  roleMenu: RoleMenu[];

  constructor(private menuService: MenuService, private http: HttpClient) { }

  ngOnInit() {
  this.dataMenu();
  this.dataRole();
    this.dataRoleMenu();

  }


  dataRoleMenu() {
    this.http.get(`http://localhost:8080/roleMenu/list`).subscribe((ob: RoleMenu[]) => {
      this.roleMenu = ob;
    });
  }


  dataMenu() {
    this.menus = this.menuService.getMenusList();
  }

  dataRole() {
    this.http
    .get(`http://localhost:8080/role/list`)
    .subscribe((ob: Role[]) => {
      this.roles = ob;
    });
  }

  isCheck(roleID : number ,menuID : number ){
    if(this.roleMenu != undefined){
      for (let index = 0; index < this.roleMenu.length; index++) {
        if(this.roleMenu[index].menu.menuId == menuID && this.roleMenu[index].role.roleId == roleID){
          return true;
        }
      }
    }
     return false;
  }
  onSelect(roleID: number, menuID: number, event) {
    const menu: Menus = {
      menuId: menuID,
      menuName: null,
      menuDescription: null,
      menuFunction: null,
    };
    const role: Role = {
      roleId: roleID,
      roleName: null,
      users: null,
    };
    const data: RoleMenu = {
      id: null,
      role: role,
      menu: menu
    };
    if (event.target.checked === true) {

      this.http.post('http://localhost:8080/roleMenu/add', data) .subscribe( () => {
        console.log("add ok");
      });
    } else {
      this.http.put('http://localhost:8080/roleMenu/delete', data) .subscribe( () => {
        console.log("delete ok");
      });
    }
  }

}
