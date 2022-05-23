package com.koehler.ehealth.cart;

import com.koehler.ehealth.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    private CartEntity cart;

    @ManyToOne
    private ProductEntity product;

    private Long quantity;
    private Date created;
    private Date updated;

}
