package com.elovell.divtrackerrest.dividend;

import com.elovell.divtrackerrest.timeseriesdailyadjusted.DailyData;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class DividendServiceImplTest {

    private DividendServiceImpl dividendService;
    private TimeSeriesDailyAdjusted timeSeriesDailyAdjusted;

    @BeforeEach
    void setUp() {
        dividendService = new DividendServiceImpl();
        DailyData dailyData1 = new DailyData();
        dailyData1.setClose(30.5);
        dailyData1.setDividendAmount(0.50);
        DailyData dailyData2 = new DailyData();
        dailyData2.setClose(28.0);
        dailyData2.setDividendAmount(0.30);
        DailyData dailyData3 = new DailyData();
        dailyData3.setClose(40.3);
        dailyData3.setDividendAmount(0.00);
        Map<String, DailyData> timeSeriesData = new HashMap<>();
        timeSeriesData.put("today", dailyData1);
        timeSeriesData.put("yesterday", dailyData2);
        timeSeriesData.put("two days ago", dailyData3);
        timeSeriesDailyAdjusted = new TimeSeriesDailyAdjusted();
        timeSeriesDailyAdjusted.setTimeSeriesData(timeSeriesData);
    }

    @Test
    void testAvgDividend() {
        double result = dividendService.avgDividend(timeSeriesDailyAdjusted);
        assertThat(result).isEqualTo(0.40);
    }

    @Test
    void testGetLastDividend() {
        double result = dividendService.getLastDividend(timeSeriesDailyAdjusted);
        assertThat(result).isEqualTo(0.30);
    }

    @Test
    void getCurrentDividendYield() {
        double result = dividendService.getCurrentDividendYield(timeSeriesDailyAdjusted);
        assertThat(result).isEqualTo(0.04285714285714286);
    }
}
