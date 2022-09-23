package com.valuemedi.projectenna.Service;


import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import com.valuemedi.projectenna.domain.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface InventoryService {

    Page<InventoryDTO> getInventories(String SupId, String prodName, boolean exp, PageRequest pageRequest);
}
