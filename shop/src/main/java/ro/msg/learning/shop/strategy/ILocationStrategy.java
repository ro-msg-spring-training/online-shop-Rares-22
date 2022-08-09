package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.ProductOrderDTO;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.exception.StrategyException;
import ro.msg.learning.shop.model.Stock;

import java.util.List;
import java.util.Map;

public interface ILocationStrategy {
    List<Stock> findBestLocations(List<ProductOrderDTO> listOfOrderedProducts);
}
