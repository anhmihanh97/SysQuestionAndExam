import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/homeService.service';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private roles: string[];
  private authority: string; // bien quyen
  info: any;
  image = [
    '../../assets/image/477451-636198978267245657-16x9.jpg',
    '../../assets/image/images.jpg',
    '../../assets/image/images (1).jpg'
  ];
  currentSlide = 0;
  tests;
  semesterExamCode = '';

  constructor(private http: HttpClient,
     private tokenStorage: TokenStorageService,
      private token: TokenStorageService, private router: Router) {
    this.changeSlide();
  }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities(); // lay thong tin quyen
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_MANAGER') {
          this.authority = 'pm';
          return false;
        }else{
          this.authority = 'user';
          return true;
        }

      });
    }
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    console.log(this.roles);
    console.log(this.info.username);
  }

  changeSlide() {
    this.currentSlide++;
    if (this.currentSlide > 3) {
      this.currentSlide = 1;
    }

    // console.log(this.currentSlide);

    setTimeout(() => {
      this.changeSlide();
    }, 3000);
  }

  showSemesterTest() {
    if (this.semesterExamCode !== '') {
      this.http
        .get(`http://localhost:8080/semester-code/${this.semesterExamCode}`)
        .subscribe(ob => {
          this.tests = ob;
        });
    }
  }

  change(e) {
    this.semesterExamCode = e.value;
    //console.log(this.semesterExamCode);
  }
  logout() {
    this.token.signOut();
    window.location.reload();
    this.router.navigate(['/']);
  }




}
