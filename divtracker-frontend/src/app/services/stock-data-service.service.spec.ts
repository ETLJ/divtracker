import { TestBed } from '@angular/core/testing';

import { StockDataServiceService } from './stock-data-service.service';

describe('StockDataServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StockDataServiceService = TestBed.get(StockDataServiceService);
    expect(service).toBeTruthy();
  });
});
