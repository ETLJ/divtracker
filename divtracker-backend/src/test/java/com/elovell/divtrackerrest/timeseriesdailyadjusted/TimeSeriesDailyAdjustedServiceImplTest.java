package com.elovell.divtrackerrest.timeseriesdailyadjusted;

import com.elovell.divtrackerrest.alphavantageapi.ApiService;
import com.elovell.divtrackerrest.stockdata.StockDataServiceImpl;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TimeSeriesDailyAdjustedServiceImplTest {

    @InjectMocks
    private StockDataServiceImpl stockDataService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ApiService apiService;

    @BeforeEach
    void setUp() {
        stockDataService = new StockDataServiceImpl(restTemplate, apiService);
    }

    @Test
    void test() {
        URI uri = URI.create("https://somesite");
        when(apiService.getUri("MSFT")).thenReturn(uri);
        stockDataService.getStockData("MSFT");
        verify(apiService).getUri("MSFT");
        verify(restTemplate).getForObject(uri, TimeSeriesDailyAdjusted.class);
    }
}
