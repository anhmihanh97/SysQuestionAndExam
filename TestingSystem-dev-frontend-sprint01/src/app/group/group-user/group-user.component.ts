import { GroupUserService } from './../group-user.service';
import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { GroupUser } from '../group-user';


@Component({
  selector: 'app-group-user',
  templateUrl: './group-user.component.html',
  styleUrls: ['./group-user.component.css']
})
export class GroupUserComponent implements OnInit {

  groupName = '';
  groupUsers: Observable<GroupUser[]>;
  constructor(private groupUserService: GroupUserService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
      this.groupUsers = this.groupUserService.getGroupUsersList();
  }

  deleteGroupUsers(id: number) {
    const result = confirm('Do you want to delete the item?');
    if (result) {
      this.groupUserService.deleteGroupUser(id).subscribe(data => {
        console.log(data);
        this.reloadData();
      },
        error => console.log('ERROR: ' + error));

    }
  }

  searchGroupUser() {
    console.log((this.groupName === '') ? ('true') : this.groupName);
    this.groupUsers = this.groupUserService.searchGroupUserByName(this.groupName);
  }

}
