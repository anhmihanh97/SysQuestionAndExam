import { HttpClient } from '@angular/common/http';
import { GroupUserService } from './../group-user.service';
import { GroupUser } from './../group-user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-group-user',
  templateUrl: './add-group-user.component.html',
  styleUrls: ['./add-group-user.component.css']
})
export class AddGroupUserComponent implements OnInit {

  submitted = false;
  groupUser: GroupUser = new GroupUser();

  constructor(private groupUserService: GroupUserService,
              private http: HttpClient,
              private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.groupUserService.createUserGroup(this.groupUser)
    .subscribe(() => this.router.navigateByUrl('/group'));
    console.log(this.groupUser);
    this.groupUser = new GroupUser();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
