import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GroupRoutingModule } from './group-routing.module';
import { GroupUserComponent } from './group-user/group-user.component';
import { AddGroupUserComponent } from './add-group-user/add-group-user.component';
import { GroupUserDetailComponent } from './group-user-detail/group-user-detail.component';

@NgModule({
  declarations: [GroupUserComponent, AddGroupUserComponent, GroupUserDetailComponent],
  imports: [
    FormsModule,
    CommonModule,
    GroupRoutingModule,
  ],
  exports: [GroupUserComponent, AddGroupUserComponent, GroupUserDetailComponent]
})
export class GroupModule { }
