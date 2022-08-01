package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.exception.StrategyException;

import java.util.Map;

public interface ILocationStrategy {
    Map<Location, Map<Product, Integer>>  getLocation(Map<Product, Integer> productQuantity4) throws StrategyException;
}
