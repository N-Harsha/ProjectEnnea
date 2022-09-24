package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.Repositories.InventoryRepository;
import com.valuemedi.projectenna.Repositories.ProductRepository;
import com.valuemedi.projectenna.api.v1.mapper.InventoryMapper;
import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import com.valuemedi.projectenna.domain.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    InventoryRepository inventoryRepository;
    ProductRepository productRepository;

    InventoryMapper inventoryMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository,InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public Page<InventoryDTO> getInventories(String supId, String prodName, boolean exp, PageRequest pageRequest) {
        Page<Inventory> inventoryList;
        Date date;
        if(exp){
            date=new Date();
        }
        else{
            date=new Date(Long.MIN_VALUE);
        }

        try{
            int x=Integer.parseInt(supId);
            inventoryList=inventoryRepository.findAll(x,prodName,date,pageRequest);
        }
        catch (Exception e){
            inventoryList=inventoryRepository.findAll(supId,prodName,date,pageRequest);
        }
        return inventoryList.map(inventoryMapper::inventoryToInventoryDTO)  ;
    }
}
