package ro.msg.learning.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTO.ProductCategoryDTO;
import ro.msg.learning.shop.DTO.builders.ProductCategoryBuilder;
import ro.msg.learning.shop.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService productCategoryService;
    private final ProductCategoryBuilder productCategoryBuilder;

    @PostMapping("/categories")
    public void saveProductCategory(@RequestBody ProductCategoryDTO productCategory) {
        this.productCategoryService.saveProductCategory(productCategoryBuilder.toProductCategory(productCategory));
    }

    @GetMapping("/categories")
    public List<ProductCategoryDTO> findAllProductCategories() {
        return this.productCategoryService.findAllProductCategories().stream().map(productCategoryBuilder::toDTO).toList();
    }

    @DeleteMapping("/categories/{id}")
    public void deleteProductCategory(@PathVariable Integer id) {
        productCategoryService.deleteProductCategory(id);
    }

    //@GetMapping("/categories/{id}")
    //public ProductCategoryDTO findProductCategoryById(@PathVariable Integer id) {
        //return productCategoryService.findProductCategoryById(id).map(productCategoryBuilder::toDTO).orElseThrow();
    //}
}