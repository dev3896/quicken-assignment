package com.assignment.quicken.controller;

import com.assignment.quicken.dto.OrderDTO;
import com.assignment.quicken.model.Order;
import com.assignment.quicken.model.Product;
import com.assignment.quicken.repository.ProductRepository;
import com.assignment.quicken.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductRepository productRepository;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDTO request) throws InterruptedException {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid product ID"));

        Order order = Order.builder()
                        .product(product)
                        .build();
        order = orderService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable @Min(1) Long id) throws Exception {
        return orderService.getOrder(id);
    }
}
