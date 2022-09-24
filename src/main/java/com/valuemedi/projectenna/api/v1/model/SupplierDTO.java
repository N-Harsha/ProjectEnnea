package com.valuemedi.projectenna.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SupplierDTO {
    Integer id;
    String name;
    Set<InventoryDTO> inventoryList;
}
