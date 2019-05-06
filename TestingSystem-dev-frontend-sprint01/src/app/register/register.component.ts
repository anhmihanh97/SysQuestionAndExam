import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { SignUpInfo } from '../auth/signup-info';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService,
    private router: Router
    ) { }

  ngOnInit() { }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.email,
        this.form.fullName,
        this.form.mobile,
        this.form.password,
        this.form.status
      );
          // subscribe là phương thức để nhận giá trị khi hàm trả về giá trị trong tương lai
          // observables các định 1 hàm nhưng đợi tới khi người dùng đăng ký để thực thi
          // subscribe()trả về một Subscription có một unsubscribe() để dừng nhận thông báo
    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        alert('Đăng Ký Thành Công ');
        this.router.navigate(['home']);
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
