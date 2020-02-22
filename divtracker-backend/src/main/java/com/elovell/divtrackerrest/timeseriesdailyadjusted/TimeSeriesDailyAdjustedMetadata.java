package com.elovell.divtrackerrest.timeseriesdailyadjusted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSeriesDailyAdjustedMetadata {
    @JsonProperty(value = "2. Symbol")
    private String symbol;

}
