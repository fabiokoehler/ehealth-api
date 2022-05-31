package com.koehler.ehealth.cart;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/cart")
public class CartProductController {

    private final CartProductService service;

    @GetMapping(path = "/{cartId}/product/{productId}")
    public CartProductDTO getCartProduct(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId) {
        return service.getCartProduct(cartId, productId);
    }
}
