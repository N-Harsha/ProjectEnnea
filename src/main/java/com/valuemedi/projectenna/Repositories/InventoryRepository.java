package com.valuemedi.projectenna.Repositories;

import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    @Query("select i from Inventory i where i.supplier in (select s.id from  Supplier s where s.name=?1) and i.product in (select p.id from Product p where p.name like %?2%) and i.expire > ?3")
    public Page<Inventory> findAll(String name, String prodName, Date date, PageRequest pageRequest);

    @Query("select i from Inventory i where i.supplier in (select s.id from  Supplier s where s.id=?1) and i.product in (select p.id from Product p where p.name like %?2%) and i.expire> ?3")
    public Page<Inventory> findAll(int id,String prodName,Date date,PageRequest pageRequest);

}
