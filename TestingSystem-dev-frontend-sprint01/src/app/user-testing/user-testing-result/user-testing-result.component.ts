import { Component, OnInit } from '@angular/core';
import { UserTestingServiceService } from '../user-testing-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/semester-exam/semester/model/User';
import { TestResult } from '../model/TestResult.interface';


@Component({
   selector: 'app-user-testing-result',
   templateUrl: './user-testing-result.component.html',
   styleUrls: ['./user-testing-result.component.css']
})
export class UserTestingResultComponent implements OnInit {
   semesterId: string
   testId: string

   testResult: TestResult;

   user: User = {
      userId: 1,
      fullName: "Nguyen Van Diem",
      mobile: "0965298776",
      password: "1234",
      email: "diemnvvn@gmail.comm",
      status: 1
   };

   constructor(private userTestingService: UserTestingServiceService, private activateRoute: ActivatedRoute, private route: Router, private http: HttpClient) { }

   ngOnInit() {
      this.initTestResult();
   }

   initTestResult() {
      this.activateRoute.paramMap.subscribe(params => {
         this.semesterId = params.get('semesterId');
         this.testId = params.get('examId');
         this.userTestingService.getResultTest(this.user.userId, this.semesterId, this.testId).subscribe(
            res => {
               console.log(res);
               this.testResult = res.data;
               this.testResult.tests = res.data.tests;
               this.testResult.numberOfQuestion = res.data.tests.exam.numberOfQuestion;
               console.log('result')
               console.log(this.testResult);
            },
            err => {
               console.log('not found 404')
            })
      }
      )
   }

}
