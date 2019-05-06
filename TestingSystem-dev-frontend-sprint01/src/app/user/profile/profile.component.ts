import { UserService } from './../../service/userService.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/entity/User.interface';
import { ActivatedRoute } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Router } from '@angular/router';

@Component ({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  private roles: string[];
  private authority: string;
  info: any;
  user: User;
  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient,
    private userService: UserService,
     private tokenStorage: TokenStorageService,
      private token: TokenStorageService,
       private router: Router
  ) { }

  ngOnInit() {
    // return this.userService.getUserById(1).subscribe(user => {
    //     this.user = user;
    // });

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
  }
}
