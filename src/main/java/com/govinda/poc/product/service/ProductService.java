package com.govinda.poc.product.service;

import com.govinda.poc.product.domain.ProductWs;

import java.util.List;

public interface ProductService {
    List<ProductWs> getProducts();

    ProductWs getProduct(String productId);

    List<ProductWs> insertProduct(ProductWs product);

    ProductWs updateProduct(ProductWs product);

    List<ProductWs> deleteProductById(String productId);

}
