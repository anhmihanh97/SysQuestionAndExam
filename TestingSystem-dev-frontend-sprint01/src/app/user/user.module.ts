import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { ListSemesterComponent } from './list-semester/list-semester.component';
import { ListTestComponent } from './list-test/list-test.component';
import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { DetailComponent } from './detail/detail.component';
import { MatListModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { PopupDeleteComponent } from './list/popup-delete/popup-delete.component';
import { MatrixUserroleComponent } from './matrix-userrole/matrix-userrole.component';

@NgModule({
  declarations: [ProfileComponent, ListSemesterComponent, ListTestComponent,ListComponent,AddComponent,
                  EditComponent,DetailComponent, PopupDeleteComponent, MatrixUserroleComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatListModule,
    MatSortModule,
    UserRoutingModule
  ],
  exports: [ProfileComponent,ListComponent,AddComponent,
    EditComponent,DetailComponent]
})
export class UserModule { }
