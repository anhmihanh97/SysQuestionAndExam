import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { mergeMap } from 'rxjs/operators';
import { User } from 'src/entity/User';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  userForm: FormGroup;
  user: User;
  isChecked: false;
  stus: string;

  constructor( 
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRouted: ActivatedRoute,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      id: [''],
      fullname: ['', Validators.required],
      email: ['', Validators.required],
      mobile: ['', Validators.required],
      password: ['', Validators.required],
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
      this.router.navigateByUrl('/user/list');
    });
  }

}
