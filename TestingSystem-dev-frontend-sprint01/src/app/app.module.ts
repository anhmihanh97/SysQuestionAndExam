import { ListExamModule } from './exam/list-exam/list-exam.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule } from '@angular/material';
import { HeaderModule } from './header/header.module';
import { NavModule } from './nav/nav.module';
import { FooterModule } from './footer/footer.module';
import { CategoryQuestionModule } from './category-question/category-question.module';
import { QuestionModule } from './question/question.module';
import { ExamModule } from './exam/exam.module';
import { CategoryModule } from './category/category.module';
import { HttpClientModule } from '@angular/common/http';

import { HttpModule } from '@angular/http';
import { UserModule } from './user/user.module';
import { HomeModule } from './home/home.module';
import { HighlightPipe } from './exam/list-exam/highlight.pipe';
import { LoginModule } from './login/login.module';
import { ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';
import { CmsComponent } from './cms/cms.component';
import { CmsModule } from './cms/cms.module';
import { RegisterComponent } from './register/register.component';
import { RegisterModule } from './register/register.module';
import { UnregisterTestingSemesterModule } from './unregister-testing-semester/unregister-testing-semester.module';
import { UserTestingSemesterModule } from './user-testing-semester/user-testing-semester.module';
import { UserTestingModule } from './user-testing/user-testing.module';
import { CourseCatalogModule } from './course-catalog/course-catalog.module';


@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    FormsModule,
    NavModule,
    HeaderModule,
    FooterModule,
    QuestionModule,
    ExamModule,
    CategoryModule,
    LoginModule,
    AppRoutingModule,
    HttpClientModule,
    ListExamModule,
    HttpModule,
    UserModule,
    HomeModule,
    CategoryQuestionModule,
    CmsModule,
    RegisterModule,
    CourseCatalogModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {


 }
