package com.valuemedi.projectenna.Batch;

import com.valuemedi.projectenna.config.DummyRead;
import com.valuemedi.projectenna.config.Wrapper;
import com.valuemedi.projectenna.domain.Inventory;
import com.valuemedi.projectenna.domain.Product;
import com.valuemedi.projectenna.domain.Supplier;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<DummyRead, Wrapper> {
    static Map<String, Supplier> supMap=new HashMap<>();
    static Map<String, Product> prodMap=new HashMap<>();

    @Override
    public Wrapper process(DummyRead dummyRead) throws Exception {
        Supplier supplier;
        Inventory inventory;
        Product product;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(supMap.containsKey(dummyRead.getSupplier())){
            supplier=supMap.get(dummyRead.getSupplier());
        }
        else{
            supplier=new Supplier();
            supplier.setName(dummyRead.getSupplier());
//            if(supplier.getName().isBlank())
//            throw new FlatFileParseException("suppler name is blank",supplier.getName());
            supMap.put(supplier.getName(),supplier);
        }
        if(prodMap.containsKey(dummyRead.getCode())){
            product=prodMap.get(dummyRead.getCode());
        }
        else{
            product=new Product();
            product.setCode(dummyRead.getCode());
            product.setCompany(dummyRead.getCompany());
            product.setName(dummyRead.getName());
            prodMap.put(product.getCode(),product);
        }
        inventory =new Inventory();
        inventory.setFree(dummyRead.getFree());
        try {
            inventory.setExpire(simpleDateFormat.parse(dummyRead.getExp()));
        }
        catch (Exception e){
            inventory.setExpire(null);
        }
        inventory.setDeal(dummyRead.getDeal());
        inventory.setBatch(dummyRead.getBatch());
        inventory.setStock(dummyRead.getStock());
        inventory.setRate(dummyRead.getRate());
        inventory.setMrp(dummyRead.getMrp());
        inventory.setProduct(product);
        supplier.addInventoryItem(inventory);
        return Wrapper.builder().inventory(inventory).supplier(supplier).product(product).build();
    }
}
