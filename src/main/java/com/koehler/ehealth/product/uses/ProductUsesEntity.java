package com.koehler.ehealth.product.uses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ProductUses")
@Table(name = "PRODUCT_USES")
public class ProductUsesEntity {

    @Id
    private Long diseaseId;
    private Long productId;
    private Date created;
    private Date updated;
}
