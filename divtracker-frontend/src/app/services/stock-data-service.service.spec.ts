import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";

import { StockDataServiceService } from './stock-data-service.service';
import { BACKEND_URL } from "../shared/global";

describe('StockDataServiceService', () => {

  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ],
    providers: [
      StockDataServiceService
    ]
  }));

  it('should be created', () => {
    const service: StockDataServiceService = TestBed.get(StockDataServiceService);
    expect(service).toBeTruthy();
  });

  it(
    'should call backend stock endpoint',
    inject(
      [HttpTestingController, StockDataServiceService],
      (httpMock: HttpTestingController, service: StockDataServiceService) => {
        service.getStockData('T').subscribe(data => {
          expect(data.close).toBe(1.45);
          expect(data.symbol).toEqual('T');
          expect(data.dividendYield).toBe(0.222);
        }
        )
        const req = httpMock.expectOne(`${BACKEND_URL}/stock/T`);
        expect(req.request.method).toEqual('GET');
        req.flush({symbol: 'T', close: 1.45, dividendYield: 0.222});
      })
  );
});
