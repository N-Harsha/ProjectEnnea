package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.Repositories.InventoryRepository;
import com.valuemedi.projectenna.Repositories.SupplierRepository;
import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Supplier;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final InventoryRepository inventoryRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository,InventoryRepository inventoryRepository) {
        this.supplierRepository = supplierRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Supplier save(Supplier supplier) {
        Set<Inventory> savedInventories = new HashSet<>();
        for(Inventory i:supplier.getInventoryList()){
            i.setSupplier(supplier);
            if(i.getId()==null)
                savedInventories.add(inventoryRepository.save(i));
            else
                savedInventories.add(i);
        }
        supplier.setInventoryList(savedInventories);
        return supplierRepository.save(supplier);
    }
}
