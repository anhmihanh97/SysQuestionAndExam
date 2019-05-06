import { Component, OnInit } from '@angular/core';
import { mergeMap, first } from 'rxjs/operators';
import { UserService } from '../user.service';
import { User } from 'src/entity/User';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  userForm: FormGroup;
  user: User;
  isChecked: false;
  stus: string;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRouted: ActivatedRoute,
    private userService: UserService,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      userId: [''],
      fullName: ['', [Validators.required,Validators.minLength(5)]],
      email: ['',[Validators.required,Validators.email]],
      mobile: ['', [Validators.required, Validators.maxLength(10),Validators.pattern('(09|01[2|6|8|9])+([0-9]{8})\b')]],
      password: ['', [Validators.required,Validators.minLength(6)]],
      status:[]

    });
    this.activatedRouted.paramMap.pipe(
      mergeMap(
        params => {
          const id = params.get('id');
          return this.userService.getUser(+id);
        }
      )
    ).subscribe(user =>
      {
        //this.user = user
      this.userForm.patchValue(user)
    });
  }


  onSubmit() {
    if( this.userForm.value.status === true){
      this.userForm.value.status = 1;
    }else{
      this.userForm.value.status = 0;
    }
    this.userService.updateUser(this.userForm.value)
    .subscribe( () => {
      alert("Edit user success!");
      this.router.navigateByUrl('cms/user/list');
    });
  }

}
