package com.koehler.ehealth.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return service.findAll();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return service.createOrder(orderDTO);
    }

}
