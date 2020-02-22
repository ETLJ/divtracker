package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;

public interface StockDataService {
    TimeSeriesDailyAdjusted getStockData(String symbol);
}
