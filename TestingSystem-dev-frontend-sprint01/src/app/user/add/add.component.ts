import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NotifierService } from 'angular-notifier';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  userForm: FormGroup;
  isChecked: boolean;

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private notifierService: NotifierService) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      userId: [''],
      fullName: ['', [Validators.required,Validators.minLength(5)]],
      email: ['',[Validators.required,Validators.email]],
      mobile: ['', [Validators.required, Validators.maxLength(10),Validators.pattern('(09|01[2|6|8|9])+([0-9]{8})\b')]],
      password: ['', [Validators.required,Validators.minLength(6)]],
      status:[''],
      role: ['']
    });
  }

  // save() {
  //   if(this.isChecked =true){
  //       this.user.status = 1
  //   }else{
  //     this.user.status = 0
  //   }
  //   this.userService.createUser(this.user)
  //     .subscribe(data => {
  //       console.log(data), error => console.log(error)
  //       this.router.navigateByUrl('/user');
  //     });
  //   this.user = new User();
  // }

  onSubmit(){
    if( this.userForm.value.status === true){
      this.userForm.value.status = 1;
    }else{
      this.userForm.value.status = 0;
    }
    this.userService.createUser(this.userForm.value)
    .subscribe( () => {
      alert("Create user success!");
      this.router.navigateByUrl('cms/user');
    });
  }



}
