package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.domain.Inventory;

import java.util.List;

public interface InventoryService {
    public Inventory save(Inventory inventory);
    public List<Inventory> findAll();
}
