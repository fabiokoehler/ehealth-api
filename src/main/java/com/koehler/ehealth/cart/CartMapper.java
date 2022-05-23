package com.koehler.ehealth.cart;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartEntity map(CartDTO source);

    CartDTO map(CartEntity source);

    List<CartDTO> map(List<CartEntity> source);
}
