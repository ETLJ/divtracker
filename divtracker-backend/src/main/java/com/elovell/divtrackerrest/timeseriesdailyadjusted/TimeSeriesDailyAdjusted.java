package com.elovell.divtrackerrest.timeseriesdailyadjusted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSeriesDailyAdjusted {
    @JsonProperty(value = "Meta Data")
    private TimeSeriesDailyAdjustedMetadata timeSeriesDailyAdjustedMetadata;
    @JsonProperty(value = "Time Series (Daily)")
    private Map<String, DailyData> timeSeriesData = new HashMap<>();
    public double mostRecentClosingPrice() {
        return timeSeriesData.values()
                .stream()
                .mapToDouble(DailyData::getClose)
                .findFirst()
                .getAsDouble();
    }
}
