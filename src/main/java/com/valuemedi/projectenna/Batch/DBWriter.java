package com.valuemedi.projectenna.Batch;

import com.valuemedi.projectenna.Repositories.InventoryRepository;
import com.valuemedi.projectenna.Repositories.ProductRepository;
import com.valuemedi.projectenna.Repositories.SupplierRepository;
import com.valuemedi.projectenna.config.Wrapper;
import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Product;
import com.valuemedi.projectenna.domain.Supplier;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBWriter implements ItemWriter<Wrapper> {

    InventoryRepository inventoryRepository;
    ProductRepository productRepository;
    SupplierRepository supplierRepository;

    public DBWriter(InventoryRepository inventoryRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void write(List<? extends Wrapper> list) throws Exception {
        List<Supplier> supplierList=new ArrayList<>();
        List<Inventory> inventoryList=new ArrayList<>();
        List<Product> productList=new ArrayList<>();

        for(Wrapper i : list){
            supplierList.add(i.getSupplier());
            productList.add(i.getProduct());
            inventoryList.add(i.getInventory());
        }
        productRepository.saveAll(productList);
        supplierRepository.saveAll(supplierList);
        inventoryRepository.saveAll(inventoryList);

    }
}
