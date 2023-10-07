package com.govinda.poc.product.service;

import com.govinda.poc.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> productList = new ArrayList<>();

    public ProductServiceImpl() {
        for (int i = 1; i <= 5; i++) {
            Product product = new Product("" + i,
                    "Product " + i,
                    "Product description " + i,
                    i + 5,
                    "Available");
            productList.add(product);
        }
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public List<Product> insertProduct(Product product) {
        productList.add(product);
        return productList;
    }

    @Override
    public Product updateProduct(Product product) {
        for (Product product1: productList) {
            if (product1.getProductId().equals(product.getProductId())) {
                if (Objects.nonNull(product.getProductName())) {
                    product1.setProductName(product.getProductName());
                }

                if (Objects.nonNull(product.getProductPrice())) {
                    product1.setProductPrice(product.getProductPrice());
                }

                if (Objects.nonNull(product.getProductDescription())) {
                    product1.setProductDescription(product.getProductDescription());
                }
                if (Objects.nonNull(product.getStatus())) {
                    product1.setStatus(product.getStatus());
                }

                return product1;
            }
        }
        return null;
    }

    @Override
    public List<Product> deleteProductById(String productId) {
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            if (iterator.next().getProductId().equals(productId)) {
                iterator.remove();
            }
        }
        return productList;
    }
}
