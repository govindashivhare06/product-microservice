package com.govinda.poc.product.controller;

import com.govinda.poc.product.domain.ProductWs;
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
    public List<ProductWs> getProductList() {
        return productService.getProducts();
    }

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductWs getProductList(@PathVariable("productId") String productId) {
        System.out.println(productId);
        return productService.getProduct(productId);
    }

    @PutMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductWs> insertProduct(@RequestBody ProductWs product) {
        return productService.insertProduct(product);
    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductWs updateProduct(@RequestBody ProductWs product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductWs> deleteProduct(@RequestBody ProductWs product) {
        return productService.deleteProductById(product.getProductId());
    }

    @DeleteMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductWs> deleteProduct(@PathVariable("productId") String productId) {
        return productService.deleteProductById(productId);
    }

}