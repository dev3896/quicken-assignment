package com.assignment.quicken.service;

import com.assignment.quicken.model.Order;
import com.assignment.quicken.model.Status;
import com.assignment.quicken.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    @Lazy
    private OrderService self;

    public Order createOrder(Order order) throws InterruptedException {
        order.setStatus(Status.PENDING);
        order = orderRepository.save(order);
        self.processOrder(order);
        return order;
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Order doesn't exist with ID " + id));
    }

    @Async
    public void processOrder(Order order) throws InterruptedException {
        Thread.sleep(3*1000L);
        order.setStatus(Status.PROCESSING);
        orderRepository.save(order);
        Thread.sleep(5*1000L);
        order.setStatus(new Random().nextBoolean() ? Status.COMPLETED : Status.FAILED);
        orderRepository.save(order);
    }
}
