import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { FormGroup } from '@angular/forms';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';


@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {
  menuName = '';
  //menus: Observable<Menu[]>;
  menus: Menu[] = [];
  keyword: string;
  emenuFrom: FormGroup;
  private roles: string[];
  private authority: string;
  displayedColumns = ['stt', 'menuName', 'menuDescription','actions'];
  dataSource: MatTableDataSource<Menu>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private menuService: MenuService,
    private tokenStorage: TokenStorageService,
    private router: Router) { }

  ngOnInit() {

    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        }
        return true;
      });
    }
    this.menuService.getMenusList()
      .subscribe(menus => {
        this.menus = menus;
        this.dataSource = new MatTableDataSource(this.menus);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });
  }


  deleteMenu(id: number) {
    const result = confirm('Do you want to delete the item?');
    if (result) {
      this.menuService.deleteMenu(id).subscribe(data => {
        console.log(data);
        //this.reloadData();
        this.menus = data;
        this.dataSource = new MatTableDataSource(this.menus);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
        this.router.navigateByUrl('/user/list');
      },
        error => console.log('ERROR: ' + error));

    }
  }

  searchMenu() {
    // console.log((this.menuName === '') ? ('true') : this.menuName);
    // this.menus = this.menuService.searchMenuByName(this.menuName);
    if(this.keyword === ''){
      this.menuService.getMenusList()
      .subscribe(menus => {
        this.menus = menus;
        this.dataSource = new MatTableDataSource(this.menus);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });
    }else {
      this.menuService.searchMenuByName(this.keyword).subscribe(menus => {
        this.menus = menus;
        this.dataSource = new MatTableDataSource(this.menus);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });

    }
  }

  // reloadData() {
  //   this.menus = this.menuService.getMenusList();
  // }
  }
