package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.dto.builders.ProductCategoryBuilder;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.service.CategoryService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.SupplierService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/productCategory")
public class CategoryController {
    private final ProductService productService;
    private final CategoryService productCategoryService;
    private final SupplierService supplierService;

    @PostMapping("/create")
    public ResponseEntity<ProductCategoryDTO> createProduct(@RequestBody ProductCategoryDTO productDto) {
        Supplier supplier = supplierService.findSupplierByName(productDto.getSupplier_name());
        Category productCategory = productCategoryService.findByName(productDto.getCategory_name());
        Product product = ProductCategoryBuilder.returnEntityFromDto(productDto, supplier, productCategory);
        Product savedProduct = productService.createProduct(product);

        return ResponseEntity.accepted().body(ProductCategoryBuilder.returnDtoFromEntity(savedProduct));
    }
    @GetMapping( "/readAll")
    public ResponseEntity<List<ProductCategoryDTO>> readAllProducts() {
        List<ProductCategoryDTO> productDtos = productService.getProducts()
                .stream()
                .map(ProductCategoryBuilder::returnDtoFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.accepted().body(productDtos);
    }
    @GetMapping( "/readById")
    public ResponseEntity<ProductCategoryDTO> readProductById(@RequestParam Integer idProduct) {
        Product product = productService.findById(idProduct);

        return ResponseEntity.accepted().body(ProductCategoryBuilder.returnDtoFromEntity(product));
    }

    @DeleteMapping( "/delete")
    public ResponseEntity<ProductCategoryDTO> deleteProduct(@RequestParam Integer idProduct) {
        Product deletedProduct = productService.deleteProduct(idProduct);

        return ResponseEntity.accepted().body(ProductCategoryBuilder.returnDtoFromEntity(deletedProduct));
    }

    @PutMapping( "/update")
    public ResponseEntity<ProductCategoryDTO> updateProduct(@RequestBody ProductCategoryDTO productDto) {
        Supplier supplier = supplierService.findSupplierByName(productDto.getSupplier_name());
        Category productCategory = productCategoryService.findByName(productDto.getCategory_name());
        Product product = ProductCategoryBuilder.returnEntityFromDto(productDto, supplier, productCategory);
        Product updatedProduct = productService.updateProduct(product.getId(), product);

        return ResponseEntity.accepted().body(ProductCategoryBuilder.returnDtoFromEntity(updatedProduct));
    }

}