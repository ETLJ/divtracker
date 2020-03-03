import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-stock-button',
  templateUrl: './new-stock-button.component.html',
  styleUrls: ['./new-stock-button.component.less']
})
export class NewStockButtonComponent implements OnInit {

  showForm: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  onClick() {
    this.showForm = true;
  }

  newStockAdded() {
    this.showForm = false;
  }

}
