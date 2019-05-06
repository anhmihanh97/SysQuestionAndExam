import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RoleComponent } from './role.component';
import { MatListModule, MatPaginatorModule, MatTableModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
import { MatrixRolemenuComponent } from './matrix-rolemenu/matrix-rolemenu.component';
import { RoleRoutingModule } from './role-routing.module';

@NgModule({
  declarations: [RoleComponent, MatrixRolemenuComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatListModule,
    RoleRoutingModule
  ],
  exports: [RoleComponent, MatrixRolemenuComponent]
})
export class RoleModule { }
