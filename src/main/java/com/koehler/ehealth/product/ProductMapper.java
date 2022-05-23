package com.koehler.ehealth.product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity map(ProductDTO source);

    ProductDTO map(ProductEntity source);

    List<ProductDTO> map(List<ProductEntity> source);
}
