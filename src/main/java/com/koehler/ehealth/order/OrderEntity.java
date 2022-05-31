package com.koehler.ehealth.order;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "SALES_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private Long userId;
    private String status;
    private Double total;
    //private Date created;
    //private Date updated;

}
