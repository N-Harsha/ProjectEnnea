package com.valuemedi.projectenna.controller.v1;


import com.valuemedi.projectenna.Service.InventoryService;
import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/supplier")
public class InventoryController {


    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{id}")
    public Page<InventoryDTO> findAll(@PathVariable String id, @RequestParam(defaultValue = "") String prodName,
                                      @RequestParam(defaultValue = "false") boolean notExp, @RequestParam(defaultValue = "0")int page,
                                      @RequestParam(defaultValue = "10")int size){
        return inventoryService.getInventories(id,prodName,notExp, PageRequest.of(page,size));
    }

}
