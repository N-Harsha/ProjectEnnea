package com.valuemedi.projectenna.api.v1.mapper;

import com.valuemedi.projectenna.api.v1.model.InventoryDTO;
import com.valuemedi.projectenna.domain.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    Inventory inventoryDTOTOInventory(InventoryDTO inventoryDTO);
    InventoryDTO inventoryToInventoryDTO(Inventory inventory);
}
