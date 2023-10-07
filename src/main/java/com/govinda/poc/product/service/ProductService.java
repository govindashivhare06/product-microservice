package com.govinda.poc.product.service;

import com.govinda.poc.product.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProduct(String productId);

    List<Product> insertProduct(Product product);

    Product updateProduct(Product product);

    List<Product> deleteProductById(String productId);

}
