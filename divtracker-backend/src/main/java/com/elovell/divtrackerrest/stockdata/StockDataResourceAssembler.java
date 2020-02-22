package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.dividend.DividendService;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import org.springframework.stereotype.Service;

@Service
public class StockDataResourceAssembler {

    private final DividendService dividendService;

    public StockDataResourceAssembler(DividendService dividendService) {
        this.dividendService = dividendService;
    }

    public StockDataResource toResource(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted) {
        StockDataResource stockDataResource = new StockDataResource();
        double dividendYield = dividendService.getCurrentDividendYield(timeSeriesDailyAdjusted);
        stockDataResource.setDividendYield(dividendYield);
        stockDataResource.setClose(timeSeriesDailyAdjusted.mostRecentClosingPrice());
        stockDataResource.setSymbol(timeSeriesDailyAdjusted.getTimeSeriesDailyAdjustedMetadata().getSymbol().toUpperCase());
        return stockDataResource;
    }
}
