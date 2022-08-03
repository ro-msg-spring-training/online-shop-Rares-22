package ro.msg.learning.shop.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductOrderDTO;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.exception.StrategyException;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.service.LocationService;
import ro.msg.learning.shop.service.StockService;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Transactional
public class SingleLocation implements ILocationStrategy{
    @Autowired
    IStockRepository stockRepository;

    @Override
    public List<Stock> findBestLocations(List<ProductOrderDTO> listOfOrderedProducts) {
        List<Stock> stocks = stockRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Stock::getQuantity).reversed())
                .collect(Collectors.toList());

        List<Stock> mostAbundantStocks = new ArrayList<>();

        listOfOrderedProducts.forEach(product -> {
            for(Stock stock: stocks) {
                if (stock.getProduct().getId().equals(product.getProductId()) &&
                        stock.getQuantity() >= product.getQuantity()) {
                    mostAbundantStocks.add(stock);
                    break;
                }
            }
        });
        return mostAbundantStocks;
    }
}
