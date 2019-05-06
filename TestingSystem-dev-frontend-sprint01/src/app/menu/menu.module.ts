import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuListComponent } from './menu-list/menu-list.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { MenuRoutingModule } from './menu-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MenuListDetailsComponent } from './menu-list-details/menu-list-details.component';
import { SearchMenuComponent } from './search-menu/search-menu.component';
import { MatPaginatorModule, MatTableModule, MatListModule, MatSortModule } from '@angular/material';

@NgModule({
  declarations: [MenuListComponent, AddMenuComponent, MenuListDetailsComponent, SearchMenuComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatListModule,
    MatSortModule,
    MenuRoutingModule
  ],
  exports: [MenuListComponent, AddMenuComponent, MenuListDetailsComponent, SearchMenuComponent]
})
export class MenuModule { }
