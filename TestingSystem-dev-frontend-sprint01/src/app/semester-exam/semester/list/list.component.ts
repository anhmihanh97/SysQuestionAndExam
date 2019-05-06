
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ApiService } from '../../service/api.service';
import { SemesterExam } from '../model/SemesterExam';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { TabsetComponent } from 'ngx-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { v4 as uuid } from 'uuid';
import Swal from 'sweetalert2';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Role } from 'src/entity/Role';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListSemComponent implements OnInit {

  @ViewChild('staticTabs') staticTabs: TabsetComponent;

  keyword: string = "";
  selectedAll: any;
  modalRef: BsModalRef;
  arrDelete: any = [];
  isCheck: boolean = false;
  check: boolean = false;
  public obj: any = {};
  public objFilter: any = {};
  public semesterExamList = [];
  private roles: string[];
  semesterExamFrm: FormGroup;
  private authority: string;
  configPagination: any;
  itempages: any = [5, 10, 15, 20];
  totalRecord: number;
  ckeConfig = {};
  roless:Role[]=[];
  public createAt: Date = new Date('dd/mm/yyyy');
  constructor(private service: ApiService, private modalService: BsModalService,
    private tokenStorage: TokenStorageService, private fb: FormBuilder ,
    private http: HttpClient) {
    this.configPagination = {
      currentPage: 1,
      itemsPerPage: 5
    }
    this.ckeConfig = { extraPlugins: 'divarea', height: 110, allowedContent: false, forcePasteAsPlainText: true, fontSize_defaultLabel: 22 }
  }

  changeItemsPerPage(event: number) {
    this.configPagination.itemsPerPage = event;
  }

  enterSearch(event) {
    if (event.key == "Enter") {
      this.searchByKeyword();
    }
  }

  getIdOfItem(event: any) {
    if (event.target.checked) {
      this.arrDelete.push(event.target.value);
    } else {
      this.arrDelete = this.arrDelete.filter(item => item !== event.target.value);
    }
  }

  isCheckAll(event: any) {
    if (event.target.checked) {
      this.isCheck = true;
      var othis = this;
      this.semesterExamList.filter(function (item) {
        othis.arrDelete.push(item.id);
      })
    } else {
      this.isCheck = false;
      this.arrDelete = [];
    }
  }

  deleteItem() {
    try {
      if (this.arrDelete.length == 0) {
        alert("Chưa chọn kỳ thi để xóa");
      } else {
        Swal.fire({
          title: 'Are you sure?',
          text: "You won't be able to revert this!",
          type: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
          if (result.value) {
            this.check = false;
            for (let i = 0; i < this.arrDelete.length; i++) {
              this.service.delete('semesterexam/delete', this.arrDelete[i]).subscribe(result => {
                if (result.status == 'SUCCESS') {
                  this.semesterExamList = result.data;
                  this.totalRecord = result.totalRecord;
                  this.deleteElementOfItempages();
                  this.check = false;
                  this.messageDeleteSuccess();
                } else {
                  this.messageDeletFailed();
                  return;
                }
              });
            }
            this.arrDelete = [];
          }
        })
      }
    } catch (error) {
      console.log(error.message);
    }
  }

  // delete element of array when displayed Showing
  deleteElementOfItempages() {
    for (let i = 0; i < this.itempages.length; i++) {
      if (this.itempages[i] >= this.totalRecord) {
        this.itempages[i] = this.totalRecord;
        this.itempages.splice(++i, this.itempages.length - i);
      }
    }
  }

  // message notification delete success
  messageDeleteSuccess() {
    Swal.fire(
      'Deleted!',
      'Xóa thành công',
      'success',
    )
  }

  // message notification delete failed
  messageDeletFailed() {
    Swal.fire(
      'Deleted!',
      'Hệ thống đang xảy ra lỗi, vui lòng thử lại sau',
      'error'
    )
  }

  semesterExamTrackByFn(semesterExam: SemesterExam) {
    return semesterExam.id;
  }

  searchByKeyword() {
    if (this.keyword == "") {
      this.service.getAll('semesterexam/all').subscribe(result => {
        this.semesterExamList = result.data;
      });
    } else {
      this.service.search('semesterexam/search', this.keyword).subscribe(result => {
        this.semesterExamList = result.data;
      });
    }
  }


  openModal(id: string, template: TemplateRef<any>) {
    this.service.getOne('semesterexam/getone', id).subscribe(result => {
      this.obj = result.data;
      this.obj.id = null;
      this.obj.startTime = "";
      this.obj.endTime = "";
      this.modalRef = this.modalService.show(template, { class: 'modal-lg' });
    })
  }

  getListSemesterExam() {
    this.service.getAll('semesterexam/all').subscribe(result => {
      this.semesterExamList = result.data;
      this.totalRecord = result.totalRecord;
      this.itempages = [5, 10, 15, 20];
      this.deleteElementOfItempages();
    });
  }

  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }
  //---------------------- ---filter ---------------------- ---

  filterData() {
    this.service.filter('semesterexam/filter', this.objFilter.name, this.objFilter.status, this.objFilter.fullname, this.objFilter.startTime, this.objFilter.endTime).subscribe(res => {
      this.semesterExamList = res.data;
    })
  }
  // ---------------------- --- end filter ---------------------- ---

  cloneSemesterExam() {
    this.obj.semesterExamCode = [];
    try {
      this.service.saveOne('semesterexam/add', this.obj).subscribe(data => {
        this.modalRef.hide();
        this.getListSemesterExam();
        Swal.fire({
          position: 'center',
          type: 'success',
          title: 'Clone Kỳ thi thành công',
          showConfirmButton: false,
          timer: 1500
        })
      });
    } catch (error) {
      console.log(error.message)
    }
  }

  ngOnInit() {
    this.dataRole();
    this.semesterExamFrm = this.fb.group({
      status: [''],
      name: [''],
      startTime: [''],
      endTime: [''],
      createdDate: [''],
      roleName: ['']
    });
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
    this.objFilter.status = -1;
    this.getListSemesterExam();
  }

  dataRole() {
    this.http
      .get(`http://localhost:8080/role/list`)
      .subscribe((ob: Role[]) => {
        this.roless = ob;
        console.log(this.roles);
      });
  }
  onSubmit() {
    console.log(this.semesterExamFrm.value);
    if (this.semesterExamFrm.valid) {
      const value = this.semesterExamFrm.value;
      const semesterExam: SemesterExam = {
        id: uuid(),
        ...value
      };
      this.http
        .post<SemesterExam[]>('http://localhost:8080/semesterexam/filter', semesterExam)
        .subscribe(result => {
          this.semesterExamList = result

        });
    }
  }
}
