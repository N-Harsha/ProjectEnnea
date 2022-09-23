package com.valuemedi.projectenna.controller.v1;


import com.valuemedi.projectenna.Repositories.InventoryRepository;
import com.valuemedi.projectenna.Service.InventoryService;
import com.valuemedi.projectenna.api.v1.mapper.InventoryMapper;
import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import com.valuemedi.projectenna.domain.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v2/")
public class InventoryController {


    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("supplier/{id}")
    public Page<InventoryDTO> findAll(@PathVariable String id, @RequestParam(defaultValue = "") String prodName,
                                      @RequestParam(defaultValue = "false") boolean notExp, @RequestParam(defaultValue = "0")int page,
                                      @RequestParam(defaultValue = "10")int size){
        return inventoryService.getInventories(id,prodName,notExp, PageRequest.of(page,size));
    }

}
