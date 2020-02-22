package com.elovell.divtrackerrest.dividend;

import com.elovell.divtrackerrest.timeseriesdailyadjusted.TimeSeriesDailyAdjusted;

public interface DividendService {
    double avgDividend(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted);
    double getLastDividend(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted);
    double getCurrentDividendYield(TimeSeriesDailyAdjusted timeSeriesDailyAdjusted);
}
