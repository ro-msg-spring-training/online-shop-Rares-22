package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Integer> {

    Optional<Stock> findStockByLocationAndProduct(Location location, Product product);

    List<Stock> findAllStockByProduct(Product product);
}
