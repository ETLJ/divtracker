package com.elovell.divtrackerrest.stockdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockData {
    @JsonProperty(value = "symbol")
    private String symbol;
}
