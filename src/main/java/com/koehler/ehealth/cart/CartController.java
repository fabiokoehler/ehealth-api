package com.koehler.ehealth.cart;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/cart")
public class CartController {

    private final CartService service;

    @GetMapping(path = "/{id}")
    public CartDTO getCart(@PathVariable("id") Long id) {
        return service.getCart(id);
    }

    @PostMapping
    public CartDTO createCard() {
        return service.createCart();
    }

    @PutMapping(path = "/{cartId}/product/{productId}", params = {"quantity"})
    public CartDTO updateCartProduct(@PathVariable(name = "cartId") Long cartId,
                                     @PathVariable(name = "productId") Long productId,
                                     @RequestParam(name = "quantity") Long quantity) {
        return service.updateCartProduct(cartId, productId, quantity);
    }

    @DeleteMapping(path = "/{cartId}/product/{productId}")
    public ResponseEntity removeProductFromCart(@PathVariable("cartId") Long cartId,
                                                @PathVariable("productId") Long productId) {
        service.removeProduct(cartId, productId);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping(path = "/{id}")
//    public CartDTO checkout(@PathVariable("id") Long id) {
//        return service.checkout(id);
//    }

}
