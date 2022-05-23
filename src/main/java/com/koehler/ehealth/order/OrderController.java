package com.koehler.ehealth.order;

import com.koehler.ehealth.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final CartService service;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return null;
    }

}
