package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.dividend.DividendService;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.DailyData;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjustedMetadata;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockDataResourceAssemblerTest {

    @InjectMocks
    private StockDataResourceAssembler stockDataResourceAssembler;

    @Mock
    private DividendService dividendService;

    private TimeSeriesDailyAdjusted timeSeriesDailyAdjusted;
    private TimeSeriesDailyAdjustedMetadata timeSeriesDailyAdjustedMetadata = new TimeSeriesDailyAdjustedMetadata();

    @BeforeEach
    void setUp() {
        DailyData dailyData1 = new DailyData();
        dailyData1.setClose(30.5);
        timeSeriesDailyAdjustedMetadata.setSymbol("MSFT");
        timeSeriesDailyAdjusted = new TimeSeriesDailyAdjusted();
        timeSeriesDailyAdjusted.setTimeSeriesDailyAdjustedMetadata(timeSeriesDailyAdjustedMetadata);
        timeSeriesDailyAdjusted.getTimeSeriesData().put("20-02-02", dailyData1);
    }

    @Test
    void toResource() {
        when(dividendService.getCurrentDividendYield(any(TimeSeriesDailyAdjusted.class))).thenReturn(2.50);
        StockDataResource stockDataResource = stockDataResourceAssembler.toResource(timeSeriesDailyAdjusted);
        verify(dividendService).getCurrentDividendYield(any(TimeSeriesDailyAdjusted.class));
        assertAll(
                () -> assertThat(stockDataResource.getClose()).isEqualTo(30.5),
                () -> assertThat(stockDataResource.getDividendYield()).isEqualTo(2.5)
        );
    }
}
