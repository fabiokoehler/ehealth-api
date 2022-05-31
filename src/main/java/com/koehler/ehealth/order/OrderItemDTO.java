package com.koehler.ehealth.order;

import com.koehler.ehealth.product.ProductDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderItemDTO {

    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private Long quantity;
    private Date created;
    private Date updated;

    private ProductDTO product;
}
