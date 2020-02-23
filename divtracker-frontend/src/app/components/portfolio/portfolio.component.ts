import { Component, OnInit } from '@angular/core';
import { Stock } from 'src/app/model/Stock';
import { StockDataServiceService } from 'src/app/services/stock-data-service.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.less']
})
export class PortfolioComponent implements OnInit {

  displayedColumns: string[] = ['symbol', 'sharesOwned', 'close', 'dividendYield'];
  portfolio: Array<Stock> = [];
  loading: boolean = true;
  stockData: Stock = {symbol: '', dividendYield: 0.00, close: 0.00};

  constructor(private stockDataService: StockDataServiceService) { }

  ngOnInit() {
    let stock1: Stock = {
      symbol: 'T',
      sharesOwned: 2
    }
    let stock2: Stock = {
      symbol: 'CAT',
      sharesOwned: 9
    }
    this.portfolio.push(stock1);
    this.portfolio.push(stock2);
    this.loadStockDataForPortfolio();
  }

  getPortfolio(): Array<Stock> {
    // this will call backend eventually
    // this should be in a PortfolioService
    return this.portfolio;
  }

  loadStockDataForPortfolio() {
    for (let stock of this.portfolio) {
      this.stockDataService.getStockData(stock.symbol).subscribe(
        stockData => {
          stock['close'] = stockData['close'];
          stock['dividendYield'] = stockData['dividendYield'];
        }
      );
    }
    this.loading = false;
  }

}
