import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-new-stock-form',
  templateUrl: './new-stock-form.component.html',
  styleUrls: ['./new-stock-form.component.less']
})
export class NewStockFormComponent implements OnInit {

  @Output() formSubmitted: EventEmitter<void> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    this.formSubmitted.emit();
  }

}
