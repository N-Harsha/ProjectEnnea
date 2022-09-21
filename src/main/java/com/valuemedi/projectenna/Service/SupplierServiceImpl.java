package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.Repositories.SupplierRepository;
import com.valuemedi.projectenna.Service.SupplierService;
import com.valuemedi.projectenna.api.v1.mapper.SupplierMapper;
import com.valuemedi.projectenna.api.v1.model.SupplierDTO;
import com.valuemedi.projectenna.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
