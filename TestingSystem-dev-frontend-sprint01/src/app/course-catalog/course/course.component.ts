import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Course } from '../entity/course';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { CourseService } from '../service/course.service';
import { HttpClient } from '@angular/common/http';
import { mergeMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { CourseCatalogService } from '../course-catalog.service';
import { NotifierService } from 'angular-notifier';
import { courseCatalog } from '../entity/courseCatalog';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courseID: number;
  courses: Course[] = [];
  keyword: string;
  displayedColumns = ['nameCourse', 'catalog', 'tuition', 'status', 'actions'];
  dataSource = new MatTableDataSource<Course>(this.courses);
  searchStr = '';
  tabAllCourse: TabInfo;
  maxPage: number;
  isSearching = false;
  @Input()
  numberOfCategory: number;
  @Input()
  entities: number;
  courseCatalog: courseCatalog[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private activatedRoute: ActivatedRoute,
    private courseService: CourseService,
    private http: HttpClient,
    private courseCatalogService: CourseCatalogService,
    private notifierService: NotifierService,
  ) { }

  ngOnInit() {
    this.loadCatalog();
    this.dataSource.sortingDataAccessor = (item, property) => {
      switch (property) {
        case 'nameCourse': return item.courseName;
        case 'tuition': return item.price;
        case 'catalog': return item.courseCatalog.categoryCourseName;
        default: return item[property];
      }
    };
    this.dataSource.sort = this.sort;
    this.tabAllCourse = { currentPage: 0, entities: 0, sizeOfPage: 5 };

    this.loadDataCourse();

  }

  loadCatalog() {
    this.courseService.getCourseCatalogList().subscribe(catalog => {
      this.courseCatalog = catalog;
    });
  }

  loadDataCourse() {
    if (this.isSearching) {
      this.courseService.getSearchCourse(this.searchStr,
        this.tabAllCourse.currentPage + '',
        this.tabAllCourse.sizeOfPage + ''
      ).subscribe(
        courses => {
          this.courses = courses;
          this.dataSource.data = this.courses;
        }
      );
      this.courseService.sumSearchCourse(this.searchStr).subscribe(
        sum => {
          this.tabAllCourse.entities = +sum;
          this.maxPage = Math.ceil(+sum / this.tabAllCourse.sizeOfPage);
        }
      );
    }
    else {
      this.courseService.getCourse(
        this.tabAllCourse.currentPage + '',
        this.tabAllCourse.sizeOfPage + ''
      ).subscribe(
        courses => {
          this.courses = courses;
          this.dataSource.data = this.courses;
        }
      );


      this.courseService.sumCourse().subscribe(
        sum => {
          this.tabAllCourse.entities = +sum;
          this.maxPage = Math.ceil(+sum / this.tabAllCourse.sizeOfPage);
        }
      );
    }


  }

  searchByContent() {
    this.tabAllCourse.currentPage = 0;
    if (this.searchStr !== '') {
      this.isSearching = true;
    } else {
      this.isSearching = false;
    }
    this.loadDataCourse();
  }

  keyPressSearch(e) {
    if (e.charCode === 13) {
      this.searchByContent();
    }
  }

  choisePage(e) {
    this.tabAllCourse.sizeOfPage = e.value;
    this.tabAllCourse.currentPage = 0;
    this.loadDataCourse();
  }

  previousPage() {
    if (this.tabAllCourse.currentPage !== 0) {
      this.tabAllCourse.currentPage--;
    } else {
      this.tabAllCourse.currentPage = 0;
    }
    this.loadDataCourse();
  }

  nextPage() {
    if (this.tabAllCourse.currentPage === this.maxPage - 1) {
      this.tabAllCourse.currentPage = this.maxPage - 1;
    } else {
      this.tabAllCourse.currentPage++;
    }
    this.loadDataCourse();
  }
  setPage(page: number) {
    this.tabAllCourse.currentPage = page;
    this.loadDataCourse();
  }


  setCourseID(id: number) {
    this.courseID = id;
  }

  cou: Course;
  deleteCourse() {
    this.courseService.getCourseById(this.courseID).subscribe(
      cou => {
        this.cou = cou;
        if (this.cou.chapters.length === 0) {
          this.courseService.deleteCourse(this.courseID).subscribe(() => {
            this.notifierService.notify('success', 'Delete successfully', '');
            this.loadDataCourse();
          });
        } else {
          this.notifierService.notify('error', 'Delete error', '');
        }
      }
    )
  }


  selectFilter(idCatalog) {
    this.courseService.filterCourse(idCatalog,
      this.tabAllCourse.currentPage + '',
      this.tabAllCourse.sizeOfPage + ''
    ).subscribe(
      courses => {
        this.courses = courses;
        this.dataSource.data = this.courses;
      }
    );


    this.courseService.sumfilterCourse(idCatalog).subscribe(
      sum => {
        this.tabAllCourse.entities = +sum;
        this.maxPage = Math.ceil(+sum / this.tabAllCourse.sizeOfPage);
      }
    );
  }

}


export interface TabInfo {
  currentPage: number;
  entities: number;
  sizeOfPage: number;
}
