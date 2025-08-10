package com.assignment.quicken.repository;

import com.assignment.quicken.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
