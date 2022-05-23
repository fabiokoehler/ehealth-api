package com.koehler.ehealth.product.uses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Uses")
@Table(name = "USES")
public class UsesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long diseaseId;
    private String name;
    private Date created;
    private Date updated;
}
