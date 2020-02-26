import { TestBed, inject } from '@angular/core/testing';

import { PortfolioService } from './portfolio.service';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { BACKEND_URL } from '../shared/global';

describe('PortfolioService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ],
    providers: [
      PortfolioService
    ]
  }));

  it('should be created', () => {
    const service: PortfolioService = TestBed.get(PortfolioService);
    expect(service).toBeTruthy();
  });

  describe('getPortfolio()', () => {
    it('should call backend to get portfolio',
    inject(
      [HttpTestingController, PortfolioService],
      (httpMock: HttpTestingController, service: PortfolioService) => {
        service.getPortfolio(1).subscribe(
          data => {
            expect(data[0].symbol).toEqual('T');
            expect(data[0].sharesOwned).toBe(2);
            expect(data[1].symbol).toEqual('CAT');
            expect(data[1].sharesOwned).toBe(3);
          }
        );
        const req = httpMock.expectOne(`${BACKEND_URL}/users/1/portfolio`);
        expect(req.request.method).toEqual('GET');
        req.flush([{symbol: 'T', sharesOwned: 2}, {symbol: 'CAT', sharesOwned: 3}])
      }
    )
    );
  });
});
