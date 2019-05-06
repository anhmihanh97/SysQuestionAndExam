import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-popup-delete',
  templateUrl: './popup-delete.component.html',
  styleUrls: ['./popup-delete.component.css']
})
export class PopupDeleteComponent implements OnInit {

  @Output() public eventName = new EventEmitter();
  public id: number;
  constructor() { }

  deleteItem(){
    this.eventName.emit(this.id);
  }
  ngOnInit() {
  }

}
