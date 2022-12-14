package com.valuemedi.projectenna.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;

    String batch;
    int stock,deal,free;
    float mrp,rate;
    Date expire;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

}
