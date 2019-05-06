import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CmsRoutingModule } from './cms-routing.module';
import { CmsComponent } from './cms.component';
import { HeaderModule } from '../header/header.module';
import { FooterModule } from '../footer/footer.module';
import { NavModule } from '../nav/nav.module';
import { ExamModule } from '../exam/exam.module';
import { QuestionModule } from '../question/question.module';
import { GroupModule } from '../group/group.module';
import { MenuModule } from '../menu/menu.module';
import { RoleModule } from '../role/role.module';
import { SemesterModule } from '../semester-exam/semester/semester.module';
import { CourseCatalogModule } from '../course-catalog/course-catalog.module';
import { DashboardModule } from '../dashboard/dashboard.module';

@NgModule({
  declarations: [CmsComponent],
  imports: [
    CommonModule,
    HeaderModule,
    FooterModule,
    NavModule,
    GroupModule,
    MenuModule,
    ExamModule,
    RoleModule,
    QuestionModule,
    CmsRoutingModule,
    MenuModule,
    SemesterModule,
    CourseCatalogModule,
    DashboardModule
  ],
  exports: [CmsComponent]
})
export class CmsModule { }
