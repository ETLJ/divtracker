import { NgModule } from '@angular/core';
import { MatTableModule } from "@angular/material/table";
import { PortfolioComponent } from './portfolio.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
      PortfolioComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
  ],
  exports: [
    PortfolioComponent
  ],
  providers: []
})
export class PortfolioModule { }
