package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.ProductCategoryException;
import ro.msg.learning.shop.exception.StockException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.ILocationRepository;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.IStockRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private static final String ERROR_MESSAGE = "stock not found for the id ";
    private final IStockRepository stockRepository;

    private final IProductRepository productRepository;
    private final ILocationRepository locationRepository;

    public void saveStock(Stock stock) {
        save(stock);
    }

    public List<Stock> findAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> findStockById(final Integer id) {
        return Optional.ofNullable(stockRepository.findById(id).orElseThrow(
                () -> new StockException(ERROR_MESSAGE + id)));
    }

    public Optional<Stock> findStockByLocationAndProduct(final Integer locationId, final Integer productId) {
        return Optional.ofNullable(stockRepository.findByLocationAndProduct(locationId, productId));
    }

    public void deleteStock(Integer productId) {
        if (stockRepository.existsById(productId)) {
            stockRepository.deleteById(productId);
        } else {
            throw (new ProductCategoryException(ERROR_MESSAGE));
        }
    }

    public void updateStock(final Stock stock) {
        if (stockRepository.existsById(stock.getId())) {
            stockRepository.save(stock);
        } else {
            throw (new StockException(ERROR_MESSAGE + stock.getId()));
        }
    }

    public void updateStock(final Integer locationId, final Integer productId, final Integer quantity) {
        Optional<Stock> stock = findStockByLocationAndProduct(locationId, productId);
        if (stock.isPresent()) {
            updateStockQuantity(stock.get(), quantity);
        } else {
            throw new StockException(ERROR_MESSAGE);
        }
    }

    public void updateStockQuantity(final Stock stock, final Integer takenQuantity) {
        if (stockRepository.existsById(stock.getId())) {
            stock.setQuantity(stock.getQuantity() - takenQuantity);
            stockRepository.save(stock);
        } else {
            throw (new StockException(ERROR_MESSAGE + stock.getId()));
        }
    }

    private void save(Stock stock) {
        Optional<Product> productOptional = productRepository.findById(stock.getProduct().getId());
        Optional<Location> locationOptional = locationRepository.findById(stock.getLocation().getId());
        if (productOptional.isPresent() && locationOptional.isPresent()) {
            Product product = productOptional.get();
            Location location = locationOptional.get();
            stock.setLocation(location);
            stock.setProduct(product);
            stockRepository.save(stock);
        } else {
            throw new StockException("invalid arguments for stock with the id" + stock.getId());
        }
    }
}