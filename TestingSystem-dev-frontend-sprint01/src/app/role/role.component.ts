import { Component, OnInit, ViewChild } from '@angular/core';
import { Role } from 'src/entity/Role';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  roles: Role[] = [];
  displayedColumns = ['stt', 'roleName'];
  dataSource: MatTableDataSource<Role>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.userService.getRoles()
      .subscribe((roles) => {
        this.roles = roles;
        this.dataSource = new MatTableDataSource(this.roles);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.paginator._intl.itemsPerPageLabel = 'Số mục trên mỗi trang:';
      });
  }

}
