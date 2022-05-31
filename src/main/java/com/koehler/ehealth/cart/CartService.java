package com.koehler.ehealth.cart;

import com.koehler.ehealth.order.OrderEntity;
import com.koehler.ehealth.order.OrderMapper;
import com.koehler.ehealth.order.OrderRepository;
import com.koehler.ehealth.product.ProductMapper;
import com.koehler.ehealth.product.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    private final CartProductRepository cartProductRepository;

    private final CartMapper mapper;
    private final CartProductMapper cartProductMapper;
    private final ProductMapper productMapper;

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public CartDTO getCart(Long id) {
        var cart = mapper.map(cartRepository.getById(id));
        var cartProducts = cartProductMapper.map(cartProductRepository.findByCartId(id));
        cartProducts.parallelStream().forEach(cartProductDTO -> cartProductDTO.setProduct(productMapper.map(productRepository.findByProductId(cartProductDTO.getProductId()))));

        cart.setProducts(cartProducts);

        return cart;
    }

    public CartDTO createCart() {
        return mapper.map(cartRepository.save(CartEntity.builder().build()));
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

        var cart = cartRepository.findById(cartId).orElseThrow();
        var product = productRepository.findById(productId).orElseThrow();
        var cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId).orElse(CartProductEntity.builder()
                .cartId(cartId)
                .productId(productId)
                .quantity(quantity).build());
        cartProduct.setQuantity(quantity);

        cartProductRepository.save(cartProduct);

        return getCart(cartId);
    }

    public void removeProduct(Long cartId, Long productId) {

        cartProductRepository.findByCartIdAndProductId(cartId, productId)
                .ifPresentOrElse(cartProductRepository::delete, RuntimeException::new);
    }

    public CartDTO checkout(Long cartId) {

        var cart = cartRepository.findById(cartId).orElseThrow();
        var products = cartProductRepository.findByCartId(cartId);

        double orderTotal = 0.0;
        var order = OrderEntity.builder().build();

        for (CartProductEntity cartProduct : products) {
            //orderTotal += cartProduct.getProduct().getPrice();
            //order.getItems().add(OrderItemEntity.builder().productId(cartProduct.getProduct().getProductId()).build());
        }
        order.setTotal(orderTotal);

        orderRepository.save(order);

        return mapper.map(cart);
    }
}
