package com.koehler.ehealth.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderDTO createOrder(OrderDTO orderDTO) {

        var order = orderRepository.save(orderMapper.map(orderDTO));

        orderDTO.getItems().forEach(orderItemDTO -> {
            orderItemDTO.setOrderId(order.getOrderId());
            orderItemRepository.save(orderItemMapper.map(orderItemDTO));
        });

        return orderMapper.map(order);
    }

    public List<OrderDTO> findAll() {

        var orders = orderMapper.map(orderRepository.findAll());
        orders.parallelStream().forEach(orderDTO -> orderDTO.setItems(orderItemMapper.map(orderItemRepository.findByOrderId(orderDTO.getOrderId()))));
        return orders;
    }
}
