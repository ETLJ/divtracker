package com.elovell.divtrackerrest.stockdata;

import lombok.Data;

@Data
public class StockDataResource {

    private String symbol;
    private double close;
    private double dividendYield;

}
