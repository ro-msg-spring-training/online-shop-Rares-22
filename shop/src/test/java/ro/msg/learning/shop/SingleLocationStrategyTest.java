package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.dto.ProductOrderDTO;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.SingleLocation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class SingleLocationStrategyTest {
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IStockRepository stockRepository;
    @InjectMocks
    private SingleLocation singleLocationStrategy;

    @BeforeEach
    public void initSingleLocationTest(){
        MockitoJUnit.rule();

        Category productCategory = new Category("Banane", "Banane proaspete");
        productCategory.setId(1);

        Supplier supplier = new Supplier("SC Banana SRL");
        supplier.setId(1);

        Product product = new Product("Banane", "Banane proaspete", new BigDecimal(6), 3.0,"banana.jpg", productCategory, supplier);
        product.setId(1);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        Location location = new Location("Profi","Romania","Cluj-Napoca","Cluj","Fantanele");
        location.setId(1);

        Stock stock = new Stock(99, product, location);
        stock.setId(1);

        List<Stock> mockedStock = new ArrayList<>();
        mockedStock.add(stock);

        when(stockRepository.findAll()).thenReturn(mockedStock);
    }

    @Test
    public void successSingleLocation(){
        List<ProductOrderDTO> listOfStocksByLocation = new ArrayList<>();
        listOfStocksByLocation.add(new ProductOrderDTO(1, 99));


        List<Stock> stock = singleLocationStrategy.findBestLocations(listOfStocksByLocation);

        assert (!stock.isEmpty());

    }

    @Test
    public void failSingleLocation() {
        List<ProductOrderDTO> listOfStocksByLocation = new ArrayList<>();
        listOfStocksByLocation.add(new ProductOrderDTO(2, 300));

        singleLocationStrategy.findBestLocations(listOfStocksByLocation);


    }

}
