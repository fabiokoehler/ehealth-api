package com.koehler.ehealth.order;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity map(OrderDTO source);

    OrderDTO map(OrderEntity source);

    List<OrderDTO> map(List<OrderEntity> source);
}
