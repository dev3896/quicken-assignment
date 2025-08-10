package com.assignment.quicken.controller;

import com.assignment.quicken.dto.ProductDTO;
import com.assignment.quicken.model.Product;
import com.assignment.quicken.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        Product result = productRepository.save(product);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
