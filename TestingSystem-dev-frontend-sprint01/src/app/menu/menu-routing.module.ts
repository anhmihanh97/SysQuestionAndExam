import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuListComponent } from './menu-list/menu-list.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { MenuListDetailsComponent } from './menu-list-details/menu-list-details.component';

const routes: Routes = [
  // {
  //   path: 'menu',
  //   children: [
  //     {
  //       path: '',
  //       redirectTo: 'list',
  //       pathMatch: 'full'
  //     },
  //     {
  //       path: 'add',
  //       component:AddMenuComponent

  //     },

  //     {
  //       path: 'list',
  //       component:MenuListComponent

  //     },

  //     {
  //       path: 'details/:id',
  //       component:MenuListDetailsComponent

  //     },



  //   ]
  // }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }
