package com.koehler.ehealth.order;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderItem")
@Table(name = "ORDER_ITEM")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private Long quantity;
    private Date created;
    private Date updated;

}
