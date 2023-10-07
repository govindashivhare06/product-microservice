package com.govinda.poc.product.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Product {
    private String productId;
    private String productName;

    private String productDescription;

    private Integer productPrice;

    private String status;

    public Product() {
    }

    public Product(String productId, String productName, String productDescription, Integer productPrice, String status) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Product {" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
