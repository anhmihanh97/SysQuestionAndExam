import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [

  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'home', pathMatch: 'full', redirectTo: '/home' },
  // {path: 'home', loadChildren: './app/app.module#AppModule'},
  { path: 'login', pathMatch: 'full', redirectTo: '/login' },
  { path: 'register', pathMatch: 'full', redirectTo: '/register' },
  // { path: 'question', pathMatch: 'full', redirectTo: '/question' },
  // { path: 'category', pathMatch: 'full', redirectTo: '/category' },
  // { path: 'exam', pathMatch: 'full', redirectTo: '/exam' },
  { path: 'user', pathMatch: 'full', redirectTo: '/user' },
  // { path: 'cms', pathMatch: 'full', redirectTo: '/cms' }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
