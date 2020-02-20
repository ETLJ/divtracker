package com.elovell.divtrackerrest.stockdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockDataController {

    private final StockDataService stockDataService;

    public StockDataController(StockDataService stockDataService) {
        this.stockDataService = stockDataService;
    }

    @GetMapping("/stock/{symbol}")
    public StockData getStockData(@PathVariable("symbol") String symbol) {
        return stockDataService.getStockData(symbol);
    }
}
