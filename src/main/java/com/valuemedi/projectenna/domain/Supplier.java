package com.valuemedi.projectenna.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier",fetch = FetchType.EAGER)
    @Builder.Default
    Set<Inventory> inventoryList=new HashSet<>();

    public void addInventoryItem(Inventory inventory){
        inventory.setSupplier(this);
        inventoryList.add(inventory);
    }
}
