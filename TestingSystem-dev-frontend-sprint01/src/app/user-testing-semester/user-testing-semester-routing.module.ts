import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { UserTestingSemesterComponent } from './user-testing-semester.component';
import { DetailComponent } from './detail/detail.component';

const routes: Routes = [
   {
      path: 'semester',
      children: [
         {
            path: '',
            component: UserTestingSemesterComponent,
         },
         {
            path: ':semesterId',
            component: DetailComponent
         }
      ]
   }
]
@NgModule({
   imports: [
      RouterModule.forChild(routes)
   ]
}
) export class UserTestingSemesterRoutingModule {

}
