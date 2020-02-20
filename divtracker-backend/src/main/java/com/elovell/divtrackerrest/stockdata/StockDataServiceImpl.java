package com.elovell.divtrackerrest.stockdata;

public class StockDataServiceImpl implements StockDataService {
    @Override
    public StockData getStockData(String symbol) {
        StockData stockData = new StockData();
        stockData.setSymbol(symbol);
        return stockData;
    }
}
