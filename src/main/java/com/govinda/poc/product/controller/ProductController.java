package com.govinda.poc.product.controller;

import com.govinda.poc.product.domain.Product;
import com.govinda.poc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-service")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductList() {
        return productService.getProducts();
    }

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductList(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> deleteProduct(@RequestBody Product product) {
        return productService.deleteProductById(product.getProductId());
    }

    @DeleteMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> deleteProduct(@PathVariable("productId") String productId) {
        return productService.deleteProductById(productId);
    }

}
