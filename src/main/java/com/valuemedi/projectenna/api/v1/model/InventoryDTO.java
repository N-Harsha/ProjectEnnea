package com.valuemedi.projectenna.api.v1.model;

import com.valuemedi.projectenna.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InventoryDTO {
    Integer id;
    Product product;
    String batch;
    int stock,deal,free;
    float mrp,rate;
    Date expire;
}
