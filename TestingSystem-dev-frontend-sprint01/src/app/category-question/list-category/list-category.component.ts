import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { Category } from 'src/entity/Category';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { mergeMap } from 'rxjs/operators';
import { v4 as uuid } from 'uuid';
import { ServiceService } from 'src/app/service.service';
import { MatTableDataSource, MatSort } from '@angular/material';
import { User } from 'src/entity/User';
import { TokenStorageService } from 'src/app/auth/token-storage.service';


@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})

export class ListCategoryComponent implements OnInit {

  listCategory: any[];
  categorys: Category[] = [];
  categoryFrm: FormGroup;
  categoryFrm2: FormGroup;
  category1: Category = new Category();
  category: Category = new Category();
  cate: Category;
  bsValue: Date;
  user: User;

  searchText: string;
  displayedColumns: string[] = ['CategoryName', 'UserCreated', 'DateCreated', 'status', 'action'];
  dataSource = new MatTableDataSource<Category>(this.listCategory);


  tabAllCategory: TabInfo;
  searchStr = '';
  isSearching = false;
  maxPage: number;
  @Input()
  numberOfCategory: number;
  @Input()
  entities: number;


  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private service: ServiceService,
    private token: TokenStorageService
  ) { }

  ngOnInit() {

    // this.reloadData();
    this.validate();

    this.dataSource.sortingDataAccessor = (item, property) => {
      switch (property) {
        case 'CategoryName': return item.categoryName;
        case 'UserCreated': return item.userCategory.fullName;
        case 'DateCreated': return item.dateCreated;
        default: return item[property];
      }
    };

    this.dataSource.sort = this.sort;

    this.tabAllCategory = { currentPage: 0, entities: 0, sizeOfPage: 5 };

    this.user = {
      userId: this.token.getUserId(),
      fullName: '',
      email: '',
      mobile: '',
      password: '',
      status: 0,
      roles: null
    };

    this.loadListCategory();

  }

  loadListCategory() {
    if (this.isSearching) {
      this.service.searchCategoryByContent(this.searchStr,
         this.tabAllCategory.currentPage + '', this.tabAllCategory.sizeOfPage + '').subscribe(
        lcategorybyContent => {
          this.listCategory = lcategorybyContent;
          this.dataSource.data = this.listCategory;
        }
      );

      this.service.countSearchCategory(this.searchStr).subscribe(
        count => {
          this.tabAllCategory.entities = +count.headers.get('CountSearchCategory'),
            this.maxPage = Math.ceil(+count.headers.get('CountSearchCategory') / this.tabAllCategory.sizeOfPage);
        }
      );
    } else {
      this.service.getCategorys(
        this.tabAllCategory.currentPage + '',
        this.tabAllCategory.sizeOfPage + ''
      ).subscribe(
        lcategory => {
          this.listCategory = lcategory;
          this.dataSource.data = this.listCategory;
        }
      );

      this.service.getCategorySum().subscribe(
        sum => {
          this.tabAllCategory.entities = +sum.headers.get('SumCategory');
          console.log(sum.headers.get('SumCategory'));
          this.maxPage = Math.ceil(+sum.headers.get('SumCategory') / this.tabAllCategory.sizeOfPage);
        }
      );
    }
  }

  updateStatus(id, status) {
   // console.log(id + "---" + status);

    if (status === 1) {
      this.service.getCategory(id).subscribe(
        q => {
          this.cate = q,
          this.cate.status = 0,
          this.service.createCategory(this.cate)
          .subscribe(() => {
            this.loadListCategory();
          });
        }
      );
    } else {
      this.service.getCategory(id).subscribe(
        q => {
          this.cate = q,
          this.cate.status = 1,
          this.service.createCategory(this.cate)
          .subscribe(() => {
            this.loadListCategory();
          });
        }
      );
    }
  }


  /** function search by content question*/
  searchByContent() {
    this.tabAllCategory.currentPage = 0;
    if (this.searchStr !== '') {
      this.isSearching = true;
    } else {
      this.isSearching = false;
    }
    this.loadListCategory();
  }

  choisePage(e) {
    this.tabAllCategory.sizeOfPage = e.value;
    this.tabAllCategory.currentPage = 0;
    this.loadListCategory();
  }

  previousPage() {
    if (this.tabAllCategory.currentPage !== 0) {
      this.tabAllCategory.currentPage--;
    } else {
      this.tabAllCategory.currentPage = 0;
    }
    this.loadListCategory();
  }

  nextPage() {
    if (this.tabAllCategory.currentPage === this.maxPage - 1) {
      this.tabAllCategory.currentPage = this.maxPage - 1;
    } else {
      this.tabAllCategory.currentPage++;
    }
    this.loadListCategory();
  }
  setPage(page: number) {
    this.tabAllCategory.currentPage = page;

    console.log(this.tabAllCategory.currentPage);

    this.loadListCategory();
  }

  keyPressSearch(e) {
    if (e.charCode === 13) {
      this.searchByContent();
    }
  }

  reloadData() {
    this.service.getCategoryList()
      .subscribe(categorys => {
        this.categorys = categorys;
        console.log(this.categorys);
      });
  }

  validate() {
    this.categoryFrm = new FormGroup({
      categoryName: new FormControl('', [Validators.required, Validators.minLength(2)]),
      userIdCreated: new FormControl(),
      dateCreated: new FormControl(new Date(), []),
    });

    this.categoryFrm2 = new FormGroup({
      categoryName: new FormControl('', [Validators.required, Validators.minLength(2)]),
      userIdCreated: new FormControl(),
      dateCreated: new FormControl(new Date(), []),
    });
  }

  onCreate() {
    if (this.categoryFrm.valid) {
      let test = this.categoryFrm.get('categoryName').value;
      this.category.categoryName = test;
      this.category.dateCreated = new Date();
      this.category.userCategory = this.user;
      this.category.status = 1;

      this.service.createCategory(this.category)
        .subscribe(() => {
          this.loadListCategory();
          this.categoryFrm.reset();
        });
    }
  }

  deleteCategory() {
    this.category1.status = 0;
    console.log(this.category1);

    this.service.createCategory(this.category1)
      .subscribe(() => {
        // this.reloadData();
        this.loadListCategory();
      });
  }


  getCategoryForCreateAndDelete(category: Category) {
    this.category1 = category;
  }

  categoryTrackByFn(category: Category) {
    return category.categoryId;
  }

  getCategoryForUpdateAndView(category: Category) {
    this.category1 = category;
    // this.categoryFrm2.patchValue(this.category1);
    this.categoryFrm2.get('categoryName').setValue(category.categoryName);
    this.categoryFrm2.get('userIdCreated').setValue(category.userCategory['fullName']);
    this.categoryFrm2.get('dateCreated').setValue(category.dateCreated);
    let date = category.dateCreated;
    this.bsValue = new Date(date);
    // console.log(this.bsValue);
  }

  // update category
  updateCategory() {
    let test = this.categoryFrm2.get('categoryName').value;
    console.log(test);
    this.category1.categoryName = test;
    // this.category1.id = Math.random();
    console.log(this.category1);

    this.service.createCategory(this.category1)
      .subscribe(() => {
        this.reloadData();
        this.categoryFrm2.reset();
      });
  }
}

export interface TabInfo {
  currentPage: number;
  entities: number;
  sizeOfPage: number;
}
