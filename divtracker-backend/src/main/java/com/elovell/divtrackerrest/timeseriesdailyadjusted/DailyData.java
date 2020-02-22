package com.elovell.divtrackerrest.timeseriesdailyadjusted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyData {

    @JsonProperty(value = "4. close")
    private double close;

    @JsonProperty(value = "7. dividend amount")
    private double dividendAmount;

    public boolean hasDividend() {
        return dividendAmount > 0.0000;
    }

    public double getDividendYield() {
        return hasDividend() ? (dividendAmount * 4.0) / close : 0;
    }
}
