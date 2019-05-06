import { Component, TemplateRef, OnInit, EventEmitter, ViewChild } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { User } from './model/User.interface';
import { UserTestingServiceService } from './user-testing-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Test } from '../semester-exam/semester/detail/test-result/test.interface';
import { Exam } from './model/Exam.interface';
import { HttpClient } from '@angular/common/http';
import { ExamQuestion } from './model/ExamQuestion.interface';
import { Observable, Subscription, interval } from 'rxjs';
import { TestingDataSubmit } from './model/TestingDataSubmit';


@Component({
   selector: 'app-user-testing',
   templateUrl: './user-testing.component.html',
   styleUrls: ['./user-testing.component.css']
})
export class UserTestingComponent implements OnInit {
   private start_time: Date;
   private startTimeString: string;
   private diff: number;
   private counter: Observable<number>;
   private subscription: Subscription;
   message: string;
   total_time: number;
   private intervalId = 0;

   @ViewChild("TimeUpTemplate") timeUpTemplate;
   @ViewChild("testResult") testResult;

   user: User = {
      userId: 1,
      fullName: "Nguyen Van Diem",
      mobile: "0965298776",
      password: "1234",
      email: "diemnvvn@gmail.comm",
      status: 1
   };

   test: Test;
   exam: Exam;
   duration: string;
   examQuestion: ExamQuestion[];
   readonly startTimeLocalstorage = 'STARTTIME'

   labelOption = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']


   modalRef: BsModalRef;
   modalRef2: BsModalRef;
   semesterId: string;
   testId: string;
   constructor(private modalService: BsModalService, private userTestingService: UserTestingServiceService, private activateRoute: ActivatedRoute, private route: Router, private http: HttpClient) {

   }

   onTimeUp(template: TemplateRef<any>) {
      this.modalService.show(template);
   }

   openModal(template: TemplateRef<any>) {
      this.modalRef = this.modalService.show(template);
   }

   closeModal() {
      this.modalRef.hide();
   }

   ngOnInit() {
      this.initTest();
      let isTested = localStorage.getItem(this.startTimeLocalstorage);
      if (!isTested) {
         this.start_time = new Date();
         localStorage.setItem(this.startTimeLocalstorage, this.start_time.toString());
      } else {
         this.start_time = new Date(isTested);
      }
      this.countDown();
   }

   private countDown() {
      this.intervalId = window.setInterval(() => {
         this.diff = this.total_time - Math.floor((new Date().getTime() - this.start_time.getTime()) / 1000);
         if (this.diff === -1) {
            clearInterval(this.intervalId);
            if (this.modalRef) {
               this.modalRef.hide();
            }
            this.modalRef2 = this.modalService.show(this.timeUpTemplate);
            setTimeout(() => {
               this.modalRef2.hide();
               this.onSubmit(this.testResult.value);
            }, 2000)
         } else {
            this.convertTimeTo(this.diff);
         }
      }, 1000);
   }

   convertTimeTo(t: number) {
      let minutes, seconds;
      minutes = Math.floor(t / 60);
      t -= minutes * 60;
      seconds = t;
      this.message = [minutes, seconds].join(":");
   }

   initTest() {
      this.activateRoute.paramMap.subscribe(params => {
         this.semesterId = params.get('semesterId');
         this.testId = params.get('examId');
         this.userTestingService.getExam(this.semesterId, this.testId).subscribe(
            res => {
               console.log(res);
               this.test = res.data;
               this.exam = res.data.exam;
               this.total_time = res.data.exam.duration * 60;
               this.examQuestion = res.data.exam.examQuestions;
               this.examQuestion.forEach(el => {
                  el.choiceOrderList = el.choiceOrder.split(" ").map(Number);
               })
            }, err => {
               console.log('not found 404');
               localStorage.setItem(this.startTimeLocalstorage, '');
            })
      }
      )
   }

   submitTest() {
      this.modalRef.hide();
      clearInterval(this.intervalId);
      setTimeout(() => {
         this.modalRef.hide();
         this.onSubmit(this.testResult.value);
      }, 1000)
   }

   onSubmit(result: object) {
      document.querySelector("#submitBtn").classList.add("disable-event-click");
      const testingData: TestingDataSubmit = {
         startTime: this.start_time,
         endTime: new Date(),
         numberOfQuestion: this.exam.numberOfQuestion,
         data: result
      };
      this.userTestingService.submitResultTest(this.user.userId, this.test.testID, testingData).subscribe(
         (res) => {
            localStorage.setItem(this.startTimeLocalstorage, '');
         },
         (error) => {
            localStorage.setItem(this.startTimeLocalstorage, '');
         },
         () => {
            this.route.navigate(['/semester', this.semesterId, 'result', this.testId], { replaceUrl: true });
            localStorage.setItem(this.startTimeLocalstorage, '');
         });
   }

   viewQuestion(questionId: string) {
      console.log('id: ' + questionId);
      document.getElementById(questionId).scrollIntoView();
   }
}
