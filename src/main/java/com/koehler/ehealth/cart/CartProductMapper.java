package com.koehler.ehealth.cart;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartProductMapper {

    CartProductEntity map(CartProductDTO source);

    CartProductDTO map(CartProductEntity source);

    List<CartProductDTO> map(List<CartProductEntity> source);
}
