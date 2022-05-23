package com.koehler.ehealth.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {

    List<CartProductEntity> findByCartCartId(Long cartId);

    Optional<CartProductEntity> findByCartCartIdAndProductProductId(Long cartId, Long productId);

}
