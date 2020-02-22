package com.elovell.divtrackerrest.alphavantageapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${alphavantage.baseUrl}")
    private String BASE_URL;

    @Value("${alphavantage.apiKey}")
    private String apiKey;

    @Override
    public URI getUri(String symbol) {
        return UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(BASE_URL)
                .path("/query")
                .queryParam("function", AlphaVantageFunction.TIME_SERIES_DAILY_ADJUSTED)
                .queryParam("symbol", symbol)
                .queryParam("outputsize", "compact")
                .queryParam("apikey", apiKey)
                .buildAndExpand()
                .encode()
                .toUri();
    }
}
