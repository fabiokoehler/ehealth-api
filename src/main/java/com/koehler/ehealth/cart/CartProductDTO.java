package com.koehler.ehealth.cart;

import com.koehler.ehealth.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CartProductDTO {

    private Long cartProductId;
    private Long cartId;
    private Long productId;
    private Long quantity;
    private ProductDTO product;

}
