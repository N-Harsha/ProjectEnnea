package com.valuemedi.projectenna.api.v1.mapper;

import com.valuemedi.projectenna.api.v1.model.SupplierDTO;
import com.valuemedi.projectenna.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
    SupplierDTO SupplierToSupplierDTO(Supplier supplier);
    Supplier SupplierDTOToSupplier(SupplierDTO supplierDTO);
}
