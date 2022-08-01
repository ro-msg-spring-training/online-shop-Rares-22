package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;

import java.util.List;
import java.util.Optional;

public interface IStockService {
     Optional<Stock> findStockByLocationAndProduct(Location location, Product product);
     Stock create(Stock stock);
     List<Stock> findAllProduct(Product product);
     List<Stock> deleteAllStocks();

}
