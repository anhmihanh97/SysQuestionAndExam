import { Component, OnInit, Input, ElementRef, ViewChild, TemplateRef } from '@angular/core';
import { ApiService } from 'src/app/semester-exam/service/api.service';
import { drawDOM, exportPDF, Group } from '@progress/kendo-drawing';
import { saveAs } from '@progress/kendo-file-saver';
import { BsModalService, BsModalRef, ModalDirective } from 'ngx-bootstrap/modal';
@Component({
   selector: 'app-report',
   templateUrl: './report.component.html',
   styleUrls: ['./report.component.css', './pdf-styles.css']
})
export class ReportComponent implements OnInit {

   @Input()
   semesterExamCode: string;
   data = Object;
   title_file: string;
   rate_title = [];
   rate_mark = [];
   modalRef: BsModalRef;
   options = {
      paperSize: "A4",
      repeatHeaders: true,
      scale: 0.8,
      margin: {
         top: "80pt"
      },
   };
   config = {};
   @ViewChild("exportPDF", { read: ElementRef }) htmlPDF: ElementRef;
   @ViewChild("templateModal") templateModal: ModalDirective;
   constructor(private apiService: ApiService, private modalService: BsModalService) { }

   ngOnInit() {
      this.getData();
   }
   getData() {
      this.apiService.getData(`semesterexam/report/${this.semesterExamCode}`).subscribe(
         result => {
            this.data = result;
            this.title_file = result.semesterExam.name;
            this.rate_title = result.rate_title;
            this.rate_mark = result.rate_mark;
         },
         error => {
         }
      );
   }
   openModal() {
      this.templateModal.show();
   }
   onExport() {
      // this.htmlPDF.nativeElement.setAttribute("class", "show");
      this.templateModal.hide();
      drawDOM(this.htmlPDF.nativeElement, this.options).then((group: Group) => {
         // this.htmlPDF.nativeElement.setAttribute("class", "hidden");
         return exportPDF(group);
      }).then((dataUri) => {
         saveAs(dataUri, `${this.title_file}-${this.semesterExamCode}.pdf`);
      });
   }
}
