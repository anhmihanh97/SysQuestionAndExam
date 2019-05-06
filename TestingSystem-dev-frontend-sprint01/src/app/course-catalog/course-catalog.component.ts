import { Component, OnInit,ViewChild } from '@angular/core';
import { CourseCatalog } from './course-catalog';
import { CourseCatalogService } from './course-catalog.service';
import { Observable } from 'rxjs';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Router } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { PopupDeleteComponent } from '../user/list/popup-delete/popup-delete.component';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-course-catalog',
  templateUrl: './course-catalog.component.html',
  styleUrls: ['./course-catalog.component.css']
})
export class CourseCatalogComponent implements OnInit {

  @ViewChild(PopupDeleteComponent) child : PopupDeleteComponent;
  keyword: string;
  courseCatalogFrom: FormGroup;
  courseCatalog: CourseCatalog[] = [];
  displayedColumns = ['stt', 'categoryCourseName', 'description', 'action'];
  dataSource: MatTableDataSource<CourseCatalog>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;




  constructor(
     private courseCatalogService: CourseCatalogService ,
     private router: Router


    ) { }

  ngOnInit() {

    this.courseCatalogService.getCourseCatalogsList()
      .subscribe((courseCatalogs) => {
        this.courseCatalog = courseCatalogs;
        this.dataSource = new MatTableDataSource(this.courseCatalog);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });







  }



  deleteCourseCatalog(id: number) {
     const checked = confirm('Do you want to delete this item');
      if (checked) {
        this.courseCatalogService.deleteCourseCatalog(id).pipe(
          mergeMap(() => this.courseCatalogService.getCourseCatalogsList())
        ).subscribe((courseCatalog) => {
          this.courseCatalog = courseCatalog;
          this.dataSource = new MatTableDataSource(this.courseCatalog);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
          this.router.navigateByUrl('/cms/coursecatalog');
        });
     }
    }

    searchCourseCatalog(){
      if(this.keyword === ''){
        this.courseCatalogService.getCourseCatalogsList()
        .subscribe(courseCatalog => {
          this.courseCatalog = courseCatalog;
          this.dataSource = new MatTableDataSource(this.courseCatalog);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
        });
      }else {
        this.courseCatalogService.searchCourseCatalogByName(this.keyword).subscribe(courseCatalog => {
          this.courseCatalog = courseCatalog;
          this.dataSource = new MatTableDataSource(this.courseCatalog);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
        });
      }

    }




  sendId(id:number){
    console.log(id);
    this.child.id = id;
  }
}
