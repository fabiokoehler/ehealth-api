package com.koehler.ehealth.cart;

import com.koehler.ehealth.order.OrderEntity;
import com.koehler.ehealth.order.OrderItemEntity;
import com.koehler.ehealth.order.OrderMapper;
import com.koehler.ehealth.order.OrderRepository;
import com.koehler.ehealth.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    private final CartProductRepository cartProductRepository;

    private final CartMapper mapper;

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public CartDTO getCart(Long id) {
        var cart = cartRepository.getById(id);
        return mapper.map(cart);
    }

    public CartDTO createCart(CartDTO cartDTO) {
        return mapper.map(cartRepository.save(mapper.map(cartDTO)));
    }

    public void deleteCart(Long cartId, Long productId) {
        cartRepository.delete(cartRepository.getById(cartId));
    }

    public CartDTO updateCart(CartDTO cartDTO) {
        if (Objects.isNull(cartDTO.getCartId())) {
            throw new RuntimeException("Bad Request");
        }
        cartRepository.getById(cartDTO.getCartId());
        return mapper.map(cartRepository.save(mapper.map(cartDTO)));
    }

    public CartDTO updateCartProduct(Long cartId, Long productId, Long quantity) {

        var cart = cartRepository.findById(cartId).orElseGet(() -> cartRepository.save(CartEntity.builder().build()));
        var product = productRepository.findById(productId).orElseThrow();

        cartProductRepository.save(CartProductEntity.builder()
                .cart(cart)
                .product(product)
                .quantity(quantity).build());


        cart.setCartProducts(cartProductRepository.findByCartCartId(cartId));

        return mapper.map(cart);
    }

    public void removeProduct(Long cartId, Long productId) {

        cartProductRepository.findByCartCartIdAndProductProductId(cartId, productId)
                .ifPresentOrElse(cartProductRepository::delete, RuntimeException::new);
    }

    public CartDTO checkout(Long cartId) {

        var cart = cartRepository.findById(cartId).orElseThrow();
        var products = cartProductRepository.findByCartCartId(cartId);

        double orderTotal = 0.0;
        var order = OrderEntity.builder().build();

        for (CartProductEntity cartProduct : products) {
            orderTotal += cartProduct.getProduct().getPrice();
            order.getItems().add(OrderItemEntity.builder().productId(cartProduct.getProduct().getProductId()).build());
        }
        order.setTotal(orderTotal);

        orderRepository.save(order);

        return mapper.map(cart);
    }
}
