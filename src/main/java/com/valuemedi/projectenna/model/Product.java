package com.valuemedi.projectenna.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String code,name,batch;
    int stock,deal,free;
    float mrp,rate;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;
}
