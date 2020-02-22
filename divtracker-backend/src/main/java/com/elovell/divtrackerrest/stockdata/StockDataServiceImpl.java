package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.alphavantageapi.ApiService;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockDataServiceImpl implements StockDataService {

    private final RestTemplate restTemplate;
    private final ApiService apiService;

    public StockDataServiceImpl(RestTemplate restTemplate, ApiService apiService) {
        this.restTemplate = restTemplate;
        this.apiService = apiService;
    }

    @Override
    public TimeSeriesDailyAdjusted getStockData(String symbol) {
        return restTemplate.getForObject(apiService.getUri(symbol), TimeSeriesDailyAdjusted.class);
    }
}
