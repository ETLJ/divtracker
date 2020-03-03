import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewStockFormComponent } from './new-stock-form.component';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";
import {MatButtonModule} from '@angular/material/button';



@NgModule({
  declarations: [NewStockFormComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule
  ],
  exports: [NewStockFormComponent]
})
export class NewStockFormModule { }
