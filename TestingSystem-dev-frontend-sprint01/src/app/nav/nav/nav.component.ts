import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Role, RoleMenu, Menus } from 'src/entity/Role';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private roles: string[];
  private authority: string;
  info: any;
  constructor(private http: HttpClient,
     private tokenStorage: TokenStorageService,
      private token: TokenStorageService,
       private router: Router) { }
  menus: Menus[];

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_MANAGER') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.http
      .get(`http://localhost:8080/role/list/${this.roles}`)
      .subscribe((ob: Menus[]) => {
        this.menus = ob;
      });
  }


  logout() {
    this.token.signOut();
    window.location.reload();
    this.router.navigate(['/']);
  }

}
