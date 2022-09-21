package com.valuemedi.projectenna.controller.v1;

import com.valuemedi.projectenna.Service.SupplierService;
import com.valuemedi.projectenna.api.v1.model.SupplierDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("api/supplier")
public class SupplierController {

    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierDTO displayProducts(@PathVariable Integer id, @RequestParam(defaultValue = "false") boolean exp){
        return supplierService.getSupplierProductsById(id,exp);
    }


}
