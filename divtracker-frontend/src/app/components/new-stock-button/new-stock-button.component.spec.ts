import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewStockButtonComponent } from './new-stock-button.component';

describe('NewStockButtonComponent', () => {
  let component: NewStockButtonComponent;
  let fixture: ComponentFixture<NewStockButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewStockButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewStockButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
