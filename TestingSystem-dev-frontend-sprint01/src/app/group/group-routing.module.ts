import { GroupUserDetailComponent } from './group-user-detail/group-user-detail.component';
import { AddGroupUserComponent } from './add-group-user/add-group-user.component';
import { GroupUserComponent } from './group-user/group-user.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroupUser } from './group-user';

const routes: Routes = [
  {
    path: 'group',
    children: [
      {
        path: '',
        component: GroupUserComponent,
        pathMatch: 'full'
      },
      {
        path: 'list',
        component: GroupUserComponent
      },
      {
        path: 'addGroupUser',
        component: AddGroupUserComponent
      },
      {
        path: 'detail/:id',
        component: GroupUserDetailComponent
      },
    ]
  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GroupRoutingModule { }
