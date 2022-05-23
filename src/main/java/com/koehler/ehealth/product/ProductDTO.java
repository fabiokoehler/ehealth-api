package com.koehler.ehealth.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private String supplier;
    private String usage;
    private Double price;
    private Long quantity;
    private Date expire;
    private Date created;
    private Date updated;

}
