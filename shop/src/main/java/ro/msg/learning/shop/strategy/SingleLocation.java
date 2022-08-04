package ro.msg.learning.shop.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dto.ProductOrderDTO;

import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.IStockRepository;

import javax.transaction.Transactional;
import java.util.*;



@RequiredArgsConstructor
@Transactional
public class SingleLocation implements ILocationStrategy{
    @Autowired
    IStockRepository stockRepository;

    @Override
    public List<Stock> findBestLocations(List<ProductOrderDTO> listOfOrderedProducts){
        List<Stock> stocks = stockRepository.findAll();
        Map<Integer, List<Stock>> locationList = new HashMap<>();

        stocks.forEach(stock -> listOfOrderedProducts.forEach(product -> {
            if (stock.getProduct().getId().equals(product.getProductId()) &&
                    stock.getQuantity() >= product.getQuantity()) {
                Integer locationID = stock.getLocation().getId();

                List<Stock> listOfStocksByLocationId = locationList.get(locationID);
                if (listOfStocksByLocationId == null)
                    listOfStocksByLocationId = new ArrayList<>();

                listOfStocksByLocationId.add(stock);
                locationList.put(locationID, listOfStocksByLocationId);
            }
        }));

        List<Stock> singleLocationStocks = null;
        Iterator<Map.Entry<Integer,List<Stock>>> it = locationList.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,List<Stock>> pair = it.next();
            if(pair.getValue().size() == listOfOrderedProducts.size()){
                singleLocationStocks = new ArrayList<>(pair.getValue());
                break;
            }
        }
        return singleLocationStocks;
    }
}
