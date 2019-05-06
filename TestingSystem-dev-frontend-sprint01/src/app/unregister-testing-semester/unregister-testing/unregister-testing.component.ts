import { Component, OnInit, TemplateRef, ElementRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Observable, Subscription, interval } from 'rxjs';
import { map } from 'rxjs/operators'


@Component({
   selector: 'app-unregister-testing',
   templateUrl: './unregister-testing.component.html',
   styleUrls: ['./unregister-testing.component.css']
})
export class UnregisterTestingComponent implements OnInit {

   modalRef: BsModalRef;
   private start_time: Date;
   private startTimeString: string;
   private diff: number;
   private counter: Observable<number>;
   private subscription: Subscription;
   private message: string;
   total_time = 5400;
   config = {
      class: 'modal-dialog-centered'
   }
   constructor(private modalService: BsModalService, elm: ElementRef) {

      this.startTimeString = "2/21/2019 18:00:00"

   }

   openModal(template: TemplateRef<any>) {
      this.modalRef = this.modalService.show(template, this.config);
   }
   convertTimeTo(t: number) {
      let days, hours, minutes, seconds;
      days = Math.floor(t / (24 * 3600));
      t -= days * 24 * 3600;
      hours = Math.floor(t / 3600);
      t -= hours * 3600;
      minutes = Math.floor(t / 60);
      t -= minutes * 60;
      seconds = t;
      this.message = [days, hours, minutes, seconds].join(":");
   }
   ngOnInit() {
      this.start_time = new Date(this.startTimeString);
      this.counter = interval(1000).pipe(
         map((x) => {
            this.diff = this.total_time -  Math.floor((new Date().getTime() - this.start_time.getTime()) / 1000);
            return x;
         }
         ));
      this.subscription = this.counter.subscribe(
         (x) =>  {
            this.convertTimeTo(this.diff);
         }
      );
   }

}
