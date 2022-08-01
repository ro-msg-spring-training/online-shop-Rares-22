package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.IStockRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService {
    private final IStockRepository stockRepository;

    public Optional<Stock> findStockByLocationAndProduct(Location location, Product product) {
        return stockRepository.findStockByLocationAndProduct(location, product);
    }

    public Stock create(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> findAllProduct(Product product) {
        return stockRepository.findAllStockByProduct(product);
    }

    public List<Stock> deleteAllStocks() {
        List<Stock> deletedStocks = stockRepository.findAll();
        stockRepository.deleteAll();
        return deletedStocks;
    }
}