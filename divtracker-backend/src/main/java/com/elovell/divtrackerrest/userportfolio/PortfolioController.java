package com.elovell.divtrackerrest.userportfolio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class PortfolioController {

    private final StockService stockService;

    public PortfolioController(StockService stockService) {
        this.stockService = stockService;
    }

    // or should this be /portfolios/{portfolioId}
    @GetMapping("/users/{userPk1}/portfolio")
    public List<Stock> getUserPortfolio(Long userPk1) {
        return stockService.findByUserPk1(userPk1);
    }

    // or should this be /portfolios/{portfolioId}/add
    @PostMapping("/users/{userPk1}/portfolio/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock, @PathVariable Long userPk1) {
        stock.setUserPk1(userPk1);
        stock.setDateCreated(LocalDateTime.now());
        stockService.save(stock);
        return ResponseEntity.ok().build();
    }
}
