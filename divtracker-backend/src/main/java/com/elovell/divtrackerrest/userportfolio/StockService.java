package com.elovell.divtrackerrest.userportfolio;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    void delete(Stock stock);
    List<Stock> findByUserPk1(Long userPk1);
}

