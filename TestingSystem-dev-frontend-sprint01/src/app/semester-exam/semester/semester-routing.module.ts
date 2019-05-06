import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListSemComponent } from './list/list.component';
import { DetailSemesterComponent } from './detail/detail.component';
import { CreateComponent } from './create/create.component';

const routes: Routes = [
  //  {
  //     path: 'semester',
  //     children: [
  //        {
  //           path: '',
  //           component: ListSemComponent,
  //        },
  //        {
  //           path: 'create',
  //           component: CreateComponent
  //        },
  //        {
  //           path: ':id',
  //           component: DetailSemesterComponent,
  //        }
  //     ]
  //  }
];

@NgModule({
   imports: [RouterModule.forChild(routes)],
   exports: [RouterModule]
})
export class SemesterRoutingModule { }
