import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { Menu } from '../menu';
import {  ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-menu-list-details',
  templateUrl: './menu-list-details.component.html',
  styleUrls: ['./menu-list-details.component.css']
})
export class MenuListDetailsComponent implements OnInit {

 
  gmenu:  Menu = new Menu();
  submitted = true;


  constructor(
    
    private route: ActivatedRoute,
    private location: Location,
    private menuService: MenuService
  ) { }

  ngOnInit() {
    this.getMenuDetail();

  }
  getMenuDetail(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.getMenuFromId(id).subscribe(menu => this.gmenu = menu);
    console.log(this.gmenu);
  }

  goBack(): void {
    this.location.back();
  }

  editMenu() {
    this.submitted = false;
  }

  obSubmit() {
    this.submitted = true;
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.updateMenu(id, this.gmenu)
    .subscribe(menu => this.gmenu = menu as Menu);
  }

}
