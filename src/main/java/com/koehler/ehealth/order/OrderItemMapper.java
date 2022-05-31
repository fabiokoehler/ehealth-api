package com.koehler.ehealth.order;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemEntity map(OrderItemDTO source);

    OrderItemDTO map(OrderItemEntity source);

    List<OrderItemDTO> map(List<OrderItemEntity> source);

}
