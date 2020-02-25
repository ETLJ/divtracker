import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortfolioComponent } from './portfolio.component';
import { MatTableModule } from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Stock } from 'src/app/model/Stock';
import { StockDataServiceService } from 'src/app/services/stock-data-service.service';
import { of } from 'rxjs';

describe('PortfolioComponent', () => {
  let component: PortfolioComponent;
  let fixture: ComponentFixture<PortfolioComponent>;
  let stockDataService: StockDataServiceService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortfolioComponent ],
      imports: [MatTableModule, BrowserAnimationsModule, HttpClientTestingModule],
      providers: [StockDataServiceService]
    })
    .compileComponents();
    stockDataService = TestBed.get(StockDataServiceService);
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfolioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('getPortfolio()', () => {
    it('should loop through stocks', () => {
      let stock1: Stock = {symbol: 'AAPL', sharesOwned: 2};
      let stock2: Stock = {symbol: 'CAT', sharesOwned: 9};
      const backendStockData1: Stock = {symbol: 'DOG', dividendYield: 0.25, close: 30.55};
      const backendStockData2: Stock = {symbol: 'AMZN', dividendYield: 0.35, close: 25.22};
      component.portfolio = [stock1, stock2];
      spyOn(stockDataService, 'getStockData').and.returnValues(of(backendStockData1), of(backendStockData2));
      component.loadStockDataForPortfolio();
      expect(component.portfolio[0].close).toBe(30.55);
      expect(component.portfolio[0].dividendYield).toBe(0.25);
      expect(component.portfolio[1].close).toBe(25.22);
      expect(component.portfolio[1].dividendYield).toBe(0.35);
      expect(component.loading).toBeFalsy();
    });
  });
});
