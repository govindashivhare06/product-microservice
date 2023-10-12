package com.govinda.poc.product.service;

import com.govinda.poc.product.dao.ProductRepository;
import com.govinda.poc.product.domain.ProductWs;
import com.govinda.poc.product.entity.Product;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    List<ProductWs> productList = new ArrayList<>();

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        for (int i = 1; i <= 5; i++) {
            ProductWs product = new ProductWs("" + i,
                    "Product " + i,
                    "Product description " + i,
                    i + 5,
                    "Available");
            productList.add(product);
        }

        this.productRepository = productRepository;
    }

    @Override
    public List<ProductWs> getProducts() {
        List<ProductWs> productList = getProductWsFromDatabase();

        return productList;
    }


    @Override
    public ProductWs getProduct(String productId) {
        ProductWs productWs = null;
        Optional<Product> product1 = productRepository.findById(Long.parseLong(productId));

        productWs = getProductWs(product1, productWs);

        return productWs;
    }

    private static ProductWs getProductWs(Optional<Product> product1, ProductWs productWs) {
        if (product1.isPresent()) {
            Product product = product1.get();
            productWs = new ProductWs();
            productWs.setProductId(product.getId().toString());
            productWs.setProductName(product.getProductName());
            productWs.setProductPrice(product.getProductPrice());
            productWs.setStatus(product.getStatus());
            productWs.setProductDescription(product.getProductDescription());
        }
        return productWs;
    }

    @Override
    public List<ProductWs> insertProduct(ProductWs productWs) {
        List<ProductWs> productList = new ArrayList<>();
        if (Objects.nonNull(productWs)) {
            Product product = new Product();
            //product.setId(Long.getLong(productWs.getProductId()));
            product.setProductName(productWs.getProductName());
            product.setProductPrice(productWs.getProductPrice());
            product.setStatus(productWs.getStatus());
            product.setProductDescription(productWs.getProductDescription());
            productRepository.save(product);
            productList.add(productWs);
        }
        return productList;
    }

    @Override
    public ProductWs updateProduct(ProductWs productWs) {
        ProductWs productWsResponse = null;
        if (Objects.nonNull(productWs) && StringUtils.isNotEmpty(productWs.getProductId())) {
            Optional<Product> product1 = productRepository.findById(Long.parseLong(productWs.getProductId()));
            if (product1.isPresent()) {
                Product product = product1.get();

                product.setStatus(productWs.getStatus());
                productRepository.save(product);
                productWsResponse = getProductWs(productRepository.findById(product.getId()), productWsResponse);
            }
        }
        return productWsResponse;
    }

    @Override
    public List<ProductWs> deleteProductById(String productId) {
        List<ProductWs> products = new ArrayList<>();
        if(!productId.isEmpty()) {
            productRepository.deleteById(Long.parseLong(productId));
            products =  getProductWsFromDatabase();
        }
        return products;
    }


    private List<ProductWs> getProductWsFromDatabase() {
        List<ProductWs> productList = new ArrayList<>();

        List<Product> products = productRepository.findAll();
        for (Product product: products) {
            ProductWs productWs = getProductWs(product);

            productList.add(productWs);
        }
        return productList;
    }

    private static ProductWs getProductWs(Product product) {
        ProductWs productWs = new ProductWs();
        productWs.setProductId(product.getId().toString());
        productWs.setProductName(product.getProductName());
        productWs.setProductPrice(product.getProductPrice());
        productWs.setStatus(product.getStatus());
        productWs.setProductDescription(product.getProductDescription());
        return productWs;
    }
}
