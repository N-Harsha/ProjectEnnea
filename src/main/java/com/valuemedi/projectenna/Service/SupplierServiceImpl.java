package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.Repositories.SupplierRepository;
import com.valuemedi.projectenna.api.v1.mapper.SupplierMapper;
import com.valuemedi.projectenna.api.v1.model.SupplierDTO;
import com.valuemedi.projectenna.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    SupplierRepository supplierRepository;
    SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDTO getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if(optionalSupplier.isPresent()){
            Supplier supplier = optionalSupplier.get();
            return supplierMapper.SupplierToSupplierDTO(supplier);
        }
        else 
            return null;
        
    }

    @Override
    public SupplierDTO getSupplierProductsById(Integer id, boolean exp) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if(optionalSupplier.isPresent()){
            Supplier supplier = optionalSupplier.get();
            if(exp) {
                    supplier.setInventoryList(supplier.getInventoryList()
                        .stream()
                        .filter(inventory -> (inventory.getExpire().after(new Date())))
                        .collect(Collectors.toSet()));
            }
            return supplierMapper.SupplierToSupplierDTO(supplier);
        }
        else
            return null;

    }
}
