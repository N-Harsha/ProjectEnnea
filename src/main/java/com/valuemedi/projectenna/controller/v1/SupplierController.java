package com.valuemedi.projectenna.controller.v1;

import com.valuemedi.projectenna.Service.SupplierService;
import com.valuemedi.projectenna.api.v1.model.SupplierDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/supplier")
public class SupplierController {

    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public SupplierDTO displayProducts(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }


}
