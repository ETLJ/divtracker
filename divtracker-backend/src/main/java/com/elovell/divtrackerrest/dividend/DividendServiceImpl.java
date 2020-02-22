package com.elovell.divtrackerrest.dividend;

import com.elovell.divtrackerrest.timeseriesdailyadjusted.DailyData;
import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DividendServiceImpl implements DividendService {

    @Override
    public double avgDividend(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted) {
        return timeSeriesDailyAdjusted.getTimeSeriesData().values()
                .stream()
                .filter(DailyData::hasDividend)
                .mapToDouble(DailyData::getDividendAmount)
                .peek(value -> log.info(String.valueOf(value)))
                .average()
                .getAsDouble();
    }

    @Override
    public double getLastDividend(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted) {
        return timeSeriesDailyAdjusted.getTimeSeriesData().values()
                .stream()
                .filter(DailyData::hasDividend)
                .mapToDouble(DailyData::getDividendAmount)
                .peek(value -> log.info(String.valueOf(value)))
                .findFirst()
                .getAsDouble();
    }

    @Override
    public double getCurrentDividendYield(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted) {
        return timeSeriesDailyAdjusted.getTimeSeriesData().values()
                .stream()
                .filter(DailyData::hasDividend)
                .mapToDouble(DailyData::getDividendYield)
                .peek(value -> log.info(String.valueOf(value)))
                .findFirst()
                .getAsDouble();
    }
}
