package com.assignment.quicken.repository;

import com.assignment.quicken.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
