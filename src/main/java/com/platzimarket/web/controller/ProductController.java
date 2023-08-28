package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // Define la clase como controlador rest de spring
@RequestMapping("/products") // Se define el path
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
