import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewStockButtonComponent } from './new-stock-button.component';
import {MatButtonModule} from '@angular/material/button';

import { NewStockFormModule } from '../new-stock-form/new-stock-form.module';

@NgModule({
  declarations: [NewStockButtonComponent],
  imports: [
    CommonModule,
    MatButtonModule,
    NewStockFormModule
  ],
  exports: [NewStockButtonComponent]
})
export class NewStockButtonModule { }
