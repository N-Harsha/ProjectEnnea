package com.valuemedi.projectenna.Repositories;

import com.valuemedi.projectenna.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
