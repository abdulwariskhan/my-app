package com.waris.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waris.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
