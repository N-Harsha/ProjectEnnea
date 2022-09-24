package com.valuemedi.projectenna.config;

import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Product;
import com.valuemedi.projectenna.domain.Supplier;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Wrapper {
    Product product;
    Inventory inventory;
    Supplier supplier;
}
