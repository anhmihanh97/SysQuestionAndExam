import { Component, OnInit, ViewChild } from '@angular/core';
import { chapters } from '../entity/chapters';
import { FormGroup } from '@angular/forms';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { ChapterService } from '../service/chapter.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { CourseService } from '../service/course.service';
import { Course } from '../entity/course';
import { mergeMap } from 'rxjs/operators';
import { Location } from '@angular/common';

@Component({
  selector: 'app-chapter',
  templateUrl: './chapter.component.html',
  styleUrls: ['./chapter.component.css']
})
export class ChapterComponent implements OnInit {

  chapters: chapters[];
  keyword: string;
  chapterFrom: FormGroup;
  displayedColumns = ['stt', 'chapterName', 'actions'];
  dataSource: MatTableDataSource<chapters>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private location: Location,
    private router: Router,
    private chapterService: ChapterService,
    private activateRoute: ActivatedRoute
  ) { }

  ngOnInit() {

    this.activateRoute.paramMap.subscribe(params => {
      const id = params.get('id');
      this.chapterService.getListChapter(+id)
        .subscribe(chapters => {
          this.chapters = chapters;
          this.dataSource = new MatTableDataSource(this.chapters);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
        });
    });

  }


  // deleteMenu(id: number) {
  //   const result = confirm('Do you want to delete the item?');
  //   if (result) {
  //     this.chapterService.deleteMenu(id).subscribe(data => {
  //       console.log(data);
  //       //this.reloadData();
  //       this.menus = data;
  //       this.dataSource = new MatTableDataSource(this.menus);
  //       this.dataSource.paginator = this.paginator;
  //       this.dataSource.sort = this.sort;
  //       this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
  //       this.router.navigateByUrl('/user/list');
  //     },
  //       error => console.log('ERROR: ' + error));

  //   }
  // }

  // searchMenu() {
  //   // console.log((this.menuName === '') ? ('true') : this.menuName);
  //   // this.menus = this.menuService.searchMenuByName(this.menuName);
  //   if(this.keyword === ''){
  //     this.menuService.getMenusList()
  //     .subscribe(menus => {
  //       this.menus = menus;
  //       this.dataSource = new MatTableDataSource(this.menus);
  //       this.dataSource.paginator = this.paginator;
  //       this.dataSource.sort = this.sort;
  //       this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
  //     });
  //   }else {
  //     this.menuService.searchMenuByName(this.keyword).subscribe(menus => {
  //       this.menus = menus;
  //       this.dataSource = new MatTableDataSource(this.menus);
  //       this.dataSource.paginator = this.paginator;
  //       this.dataSource.sort = this.sort;
  //       this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
  //     });

  //   }
  // }


  back() {
    this.location.back();
  }


}
