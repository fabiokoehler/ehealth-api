package com.koehler.ehealth.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {

    //@Query(value = "select * from CART_PRODUCT where cart_id = :cartId ", nativeQuery = true)
    List<CartProductEntity> findByCartId(Long cartId);

    Optional<CartProductEntity> findByCartIdAndProductId(Long cartId, Long productId);


}
