import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { MenuService } from '../menu.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

//import { FormGroup, FormControl,FormBuilder } from '@angular/forms';



@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {
  //addform: FormGroup;
  menu: Menu = new Menu();
  submitted = false;

  constructor(private menuService: MenuService,
    private http: HttpClient,
    private router: Router
   ) { }

  ngOnInit() {


  }

  newMenu(): void {
    this.submitted = false;
    this.menu = new Menu();
  }
  // save() {
  //   this.menuService.createMenu(this.menu)
  //     .subscribe(data => console.log(data), error => console.log(error));
  //   this.menu = new Menu();
  // }

  save() {
    this.menuService.createMenu(this.menu)
    .subscribe(() => this.router.navigateByUrl('/cms/menu'));
    this.menu = new Menu();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
