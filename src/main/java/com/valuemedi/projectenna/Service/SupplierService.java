package com.valuemedi.projectenna.Service;

import com.valuemedi.projectenna.api.v1.model.SupplierDTO;

public interface SupplierService {
    public SupplierDTO getSupplierById(Integer id);

    SupplierDTO getSupplierProductsById(String id, boolean exp,int page,int size,String name);
}
