package com.valuemedi.projectenna.BootStrap;

        import com.valuemedi.projectenna.Repositories.InventoryRepository;
        import com.valuemedi.projectenna.Repositories.ProductRepository;
        import com.valuemedi.projectenna.Repositories.SupplierRepository;
        import com.valuemedi.projectenna.domain.Inventory;
        import com.valuemedi.projectenna.domain.Product;
        import com.valuemedi.projectenna.domain.Supplier;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    InventoryRepository inventoryRepository;
    ProductRepository productRepository;
    SupplierRepository supplierRepository;

    public BootStrap(InventoryRepository inventoryRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Supplier sup1=Supplier.builder().name("ABC").build();
        Supplier sup2=Supplier.builder().name("DEF").build();
        Supplier sup3=Supplier.builder().name("GHI").build();

        Product prod1 = Product.builder().name("kdfs").code("LOL").build();
        Product prod2 = Product.builder().name("yrds").code("KFKE").build();
        Product prod3 = Product.builder().name("dfksl").code("TROI").build();

        Product savedProd1 = productRepository.save(prod1);
        Product savedProd2 = productRepository.save(prod2);
        Product savedProd3 = productRepository.save(prod3);

        Inventory inventory1 = Inventory.builder().product(savedProd1).batch("Alpha").build();
        Inventory inventory2 = Inventory.builder().product(savedProd2).batch("Beta").build();
        Inventory inventory3 = Inventory.builder().product(savedProd1).batch("Beta").build();
        Inventory inventory4 = Inventory.builder().product(savedProd1).batch("Alpha").build();
        Inventory inventory5 = Inventory.builder().product(savedProd3).batch("Alpha").build();

        //todo add validataion to  the products with same type and avooid duplication of products.
        sup1.addInventoryItem(inventory1);
        sup1.addInventoryItem(inventory2);
        sup1.addInventoryItem(inventory3);
        sup1.addInventoryItem(inventory4);
        sup3.addInventoryItem(inventory5);


        supplierRepository.save(sup1);
        supplierRepository.save(sup2);
        supplierRepository.save(sup3);

    }
}
