import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CmsComponent } from './cms.component';
import { ListExamComponent } from '../exam/list-exam/list-exam.component';
import { ListQuestionComponent } from '../question/list-question/list-question.component';
import { GroupUserComponent } from '../group/group-user/group-user.component';
import { AddGroupUserComponent } from '../group/add-group-user/add-group-user.component';
import { GroupUserDetailComponent } from '../group/group-user-detail/group-user-detail.component';
import { MenuListComponent } from '../menu/menu-list/menu-list.component';
import { RoleComponent } from '../role/role.component';
import { ProfileComponent } from '../user/profile/profile.component';
import { DetailExamComponent } from '../exam/detail-exam/detail-exam.component';
import { CreateExamComponent } from '../exam/create-exam/create-exam.component';
import { UpdateExamComponent } from '../exam/update-exam/update-exam.component';
import { UpdateCommonComponent } from '../exam/update-common/update-common.component';
import { UpdateContentComponent } from '../exam/update-content/update-content.component';

import { CreateComponent } from '../semester-exam/semester/create/create.component';
import { ListSemComponent } from '../semester-exam/semester/list/list.component';
import { DetailSemesterComponent } from '../semester-exam/semester/detail/detail.component';
import { UnregisterTestingSemesterComponent } from '../unregister-testing-semester/unregister-testing-semester.component';
import { UserTestingComponent } from '../user-testing/user-testing.component';
import { UserTestingResultComponent } from '../user-testing/user-testing-result/user-testing-result.component';

import { EditQuestionComponent } from '../question/edit-question/edit-question.component';
import { ViewQuestionComponent } from '../question/view-question/view-question.component';
import { IplistQuestionComponent } from '../question/iplist-question/iplist-question.component';
import { CreateQuestionComponent } from '../question/create-question/create-question.component';
import { ListCategoryComponent } from '../category-question/list-category/list-category.component';
import { ListSemesterComponent } from '../user/list-semester/list-semester.component';
import { ListTestComponent } from '../user/list-test/list-test.component';
import { ListComponent } from '../user/list/list.component';
import { AddComponent } from '../user/add/add.component';
import { EditComponent } from '../user/edit/edit.component';
import { DetailComponent } from '../user/detail/detail.component';
import { MenuListDetailsComponent } from '../menu/menu-list-details/menu-list-details.component';
import { AddMenuComponent } from '../menu/add-menu/add-menu.component';
import { MatrixRolemenuComponent } from '../role/matrix-rolemenu/matrix-rolemenu.component';
import { MatrixUserroleComponent } from '../user/matrix-userrole/matrix-userrole.component';
import { CourseComponent } from '../course-catalog/course/course.component';
import { CourseCatalogComponent } from '../course-catalog/course-catalog.component';
import { ChapterComponent } from '../course-catalog/chapter/chapter.component';
import { LessonComponent } from '../course-catalog/lesson/lesson.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { UpdateCourseComponent } from '../course-catalog/course/update-course/update-course.component';
import { DetailCourseComponent } from '../course-catalog/course/detail-course/detail-course.component';
import { AddCourseComponent } from '../course-catalog/course/add-course/add-course.component';
import { AddCourseCatalogComponent } from '../course-catalog/add-course-catalog/add-course-catalog.component';
import { CourseCatalogEditComponent } from '../course-catalog/course-catalog-edit/course-catalog-edit.component';
import { CreateLessonComponent } from '../course-catalog/lesson/create-lesson/create-lesson.component';



const routes: Routes = [
  {
    path: 'cms',
    component: CmsComponent,
    children: [
      {
        path: '',
        component: DashboardComponent,
        pathMatch: 'full'
      },
      {
        path: 'exam',
        component: ListExamComponent,
        pathMatch: 'full'
      },
      {
        path: 'exam/create',
        component: CreateExamComponent,
      },
      {
        path: 'exam/:id',
        component: DetailExamComponent
      },
      {
        path: 'exam/:id/update',
        component: UpdateExamComponent
      },
      {
        path: 'exam/:id/update/update-common',
        component: UpdateCommonComponent
      },
      {
        path: 'exam/:id/update/update-content',
        component: UpdateContentComponent
      },
      {
        path: 'question',
        component: ListQuestionComponent,
        pathMatch: 'full'
      },

      {
        path: 'question/create',
        component: CreateQuestionComponent
      },
      {
        path: 'question/importlist',
        component: IplistQuestionComponent
      },
      {
        path: 'question/:id',
        component: ViewQuestionComponent
      },
      {
        path: 'question/:id/edit',
        component: EditQuestionComponent
      },
      {
        path: 'category',
        children: [
          {
            path: '',
            component: ListCategoryComponent,
            pathMatch: 'full'
          }
        ]
      },
      {
        path: 'group',
        component: GroupUserComponent
      },
      {
        path: 'menu',
        component: MenuListComponent,
        pathMatch: 'full'
      },

      {
        path: 'menu/details/:id',
        component: MenuListDetailsComponent

      },
      {
        path: 'menu/create',
        component: AddMenuComponent

      },
      {
        path: 'role',
        component: RoleComponent,
        pathMatch: 'full'
      },
      {
        path: 'role/role-menu',
        component: MatrixRolemenuComponent,
        pathMatch: 'full'
      },
      {
        path: 'user/user-role',
        component: MatrixUserroleComponent,
        pathMatch: 'full'
      },
      {
        path: 'semester',
        component: ListSemComponent,
        pathMatch: 'full'
      },
      {
        path: 'semester/create',
        component: CreateComponent
      },
      {
        path: 'semester/:id',
        component: DetailSemesterComponent
      },

      //     {
      //       path: 'guest/semesters/:semesterCode',
      //       component: UnregisterTestingSemesterComponent
      //    },
      //    {
      //     path: 'semester/:semesterId/testing/:examId',
      //     component: UserTestingComponent,
      //  },
      //  {
      //     path: 'semester/:semesterId/result/:examId',
      //     component: UserTestingResultComponent,
      //  }


      {
        path: 'user',
        component: ListComponent
      },
      {
        path: 'user/create',
        component: AddComponent
      },
      {
        path: 'user/:id/edit',
        component: EditComponent
      },
      {
        path: 'user/:id/detail',
        component: DetailComponent
      },
      {
        path: 'coursecatalog',
        component: CourseCatalogComponent,
        pathMatch: 'full'
      },
      {
        path: 'coursecatalog/search',
        component: CourseCatalogComponent,
        pathMatch: 'full'
      },
      {
        path: 'coursecatalog/add',
        component: AddCourseCatalogComponent,
        pathMatch: 'full'
      },
      {
        path: 'coursecatalog/:id/edit',
        component: CourseCatalogEditComponent,
        pathMatch: 'full'
      },
      {
        path: 'course/add',
        component: AddCourseComponent,
        pathMatch: 'full'
      },
      {
        path: 'course',
        component: CourseComponent,
        pathMatch: 'full'
      },
      {
        path: 'course/:id/chapter',
        component: ChapterComponent,
        pathMatch: 'full'
      },
      {
        path: 'course/:id',
        component: DetailCourseComponent,
        pathMatch: 'full'
      },

      {
        path: 'course/:id/update',
        component: UpdateCourseComponent,
        pathMatch: 'full'
      },
      {
        path: 'course/:id/chapter/:id/lesson',
        component: LessonComponent,
        pathMatch: 'full'
      },
      {
        path: 'course/:id/chapter/:chapterId/lesson/createlesson',
        component: CreateLessonComponent,
        pathMatch: 'full'
      },
      {
        path: 'dashboard',
        component: DashboardComponent,
        pathMatch: 'full'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CmsRoutingModule { }
