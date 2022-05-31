package com.koehler.ehealth.cart;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CartProduct")
@Table(name = "CART_PRODUCT")
public class CartProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartProductId;
    private Long cartId;
    private Long productId;
    private Long quantity;
    private Date created;
    private Date updated;

}
