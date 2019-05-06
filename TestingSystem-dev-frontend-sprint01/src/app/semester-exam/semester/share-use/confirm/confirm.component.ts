import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
   selector: 'app-confirm',
   templateUrl: './confirm.component.html',
   styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

   constructor() { }

   openPopup() {
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
            Swal.fire(
               'Deleted!',
               'Your file has been deleted.',
               'success'
            )
         }
      })
   }

   deleteSuccess() {
      Swal.fire(
         'Deleted!',
         'Your file has been deleted.',
         'success'
      )
   }

   ngOnInit() {
   }

}
