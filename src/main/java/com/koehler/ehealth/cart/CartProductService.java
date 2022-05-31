package com.koehler.ehealth.cart;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CartProductService {

    private final CartProductRepository cartProductRepository;
    private final CartProductMapper cartProductMapper;

    public CartProductDTO  getCartProduct(Long cartId, Long productId) {
        return cartProductMapper.map(cartProductRepository.findByCartIdAndProductId(cartId, productId).orElse(CartProductEntity.builder().quantity(0L).build()));
    }
}
