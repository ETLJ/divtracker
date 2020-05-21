package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockDataController {

    private final StockDataService stockDataService;
    private final StockDataResourceAssembler stockDataResourceAssembler;

    @GetMapping("/stock/{symbol}")
    @CrossOrigin
    public StockDataResource getStockData(@PathVariable("symbol") String symbol) {
        TimeSeriesDailyAdjusted timeSeriesDailyAdjusted = stockDataService.getStockData(symbol);
        return stockDataResourceAssembler.toResource(timeSeriesDailyAdjusted);
    }
}
