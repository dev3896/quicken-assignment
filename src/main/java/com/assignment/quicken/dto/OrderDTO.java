package com.assignment.quicken.dto;

import com.assignment.quicken.model.Status;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderDTO {
    @Min(value = 1,message = "Order ID must be a positive number")
    private Long orderId;
    @Min(value = 1,message = "Product ID must be a positive number")
    private Long productId;
    private Status status;
}
