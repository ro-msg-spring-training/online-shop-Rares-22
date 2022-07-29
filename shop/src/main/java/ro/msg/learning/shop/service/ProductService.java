package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.ProductCategoryDTO;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    @Autowired
    private final IProductRepository product;

    ProductService(IProductRepository product){
        this.product=product;
    }


    public void getAllProductCategory() {
         ((List<Product>)
                product.findAll())
                .stream()
                .map(this::convertToProductCategoryDTO)
                .collect(Collectors.toList());
    }

    private ProductCategoryDTO convertToProductCategoryDTO(Product product) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setId(product.getId());
        productCategoryDTO.setName(product.getName());
        productCategoryDTO.setPrice(product.getPrice());
        productCategoryDTO.setWeight(product.getWeight());
        Category category = product.getCategory();
        productCategoryDTO.setDescription(category.getDescription());

        return productCategoryDTO;
    }
    @Override
    public void createProduct(Product newProduct) {
        product.save(newProduct);
    }
    @Override
    public void updateProduct(Integer id, Product newProduct) {
        product.save(newProduct);
    }
    @Override
    public void deleteProduct(Integer id) {
        product.deleteById(id);

    }
    @Override
    public Collection<Product> getProducts() {
        return product.findAll();
    }
}
