import { UserService } from './../../user/user.service';
import { Observable } from 'rxjs';
import { GroupUserService } from './../group-user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { GroupUser } from '../group-user';
import { MatTableDataSource } from '@angular/material';
import { mergeMap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { User } from 'src/entity/User';

@Component({
  selector: 'app-group-user-detail',
  templateUrl: './group-user-detail.component.html',
  styleUrls: ['./group-user-detail.component.css']
})
export class GroupUserDetailComponent implements OnInit {

  disable = false;
  users1: User[] = [];
  users2: User[] = [];
  users3: User[];
  // group: GroupUser;
  gUser: GroupUser = new GroupUser();
  submitted = true;
  added = true;
  dataSource: MatTableDataSource<User>;

  constructor(
    private route: ActivatedRoute,
    private groupUserService: GroupUserService,
    private location: Location,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getGroupUserDetail();
    this.getAllUsers();
    this.getUsersFromGroup();
  }

  getGroupUserDetail(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.groupUserService.getGroupUserFromId(id).subscribe(groupUser => this.gUser = groupUser);
    // console.log(this.gUser);
  }

  goBack(): void {
    this.location.back();
  }

  onClick(): void {
    this.added = false;
  }

  editGroupUser() {
    this.submitted = false;
  }

  onSubmit() {
    this.submitted = true;
    const id = +this.route.snapshot.paramMap.get('id');
    this.groupUserService.updateUserGroup(id, this.gUser)
      .subscribe(groupUser => this.gUser = groupUser as GroupUser);
  }

  // get all users in database. this case only if to get users from one groups
  getAllUsers(): void {
    this.userService.getUsersList().subscribe(data => {
      this.users2 = data;
      this.dataSource = new MatTableDataSource(this.users2);
      console.log('users2 ============');
      console.log(this.users2);
    });
  }

  // get all users from one groups
  getUsersFromGroup(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.groupUserService.getUsersFromGroupId(id).subscribe(data => {
      this.users1 = data;
      this.dataSource = new MatTableDataSource(this.users1);
      console.log('users1 ==============');
      console.log(this.users1);
    });
  }

  addUser(group_id: number, user_id: number): void {
    this.getAllUsers();
    this.groupUserService.addUserIntoGroup(group_id, user_id).subscribe(data => {
      this.users1 = data;
      this.dataSource = new MatTableDataSource(this.users1);
      this.router.navigateByUrl(`/group/detail` + `/${group_id}`);
      // console.log(this.users1);
    });
    // this.reloadUser();
  }

  // reloadUser(): void {
  //   console.log('***** users1 ******' + this.users1);
  //   console.log('***** users2 ******' + this.users2);
  //   this.users2.forEach(element => {
  //     this.users1.forEach(item => {
  //       if (element.id === item.id) {
  //         continue;
  //       }
  //     });
  //   });
  //   // const result = this.users2.filter(
  //   //   item => !this.users1.includes .includes(item.id));
  //   //   console.log('+++++++++++++++++' + result);
  // }

  deleteUser(user_id: number, group_id: number) {
    const checked = confirm('Do you want to delete this item');
    if (checked) {
      this.groupUserService.deleteUserFromGroup(group_id, user_id).pipe(
        mergeMap(() => this.groupUserService.getUsersFromGroupId(group_id))
      ).subscribe((data) => {
        this.users1 = data;
        this.dataSource = new MatTableDataSource(this.users1);
        this.router.navigateByUrl(`/group/detail` + `/${group_id}`);
        // console.log(this.users1);
      });
      // this.reloadUser();
    }
  }

  checkUserId(): void {
    console.log('***** users1 ******' + this.users1);
    console.log('***** users2 ******' + this.users2);
    this.users2.forEach(element => {
      this.users1.forEach(item => {
        if (item.userId === element.userId) {
          this.disable = true;
        }
      });
    });
  }
}
