package com.govinda.poc.product.dao;

import com.govinda.poc.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    Optional<Product> findById(Long id);
}
