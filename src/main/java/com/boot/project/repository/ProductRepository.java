package com.boot.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
