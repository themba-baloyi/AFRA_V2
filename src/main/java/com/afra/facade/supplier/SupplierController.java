package com.afra.facade.supplier;

import com.afra.entities.SuppliersEntities;
import com.afra.services.suppliers.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/supplier")
public class SupplierController implements Supplier {

    @Autowired
    SupplierServiceImpl service;

    @CrossOrigin
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<SuppliersEntities>> getAllSuppliers() {
        return service.getAllSuppliers();
    }

    @CrossOrigin
    @Override
    @GetMapping("/byId/{id}")
    public ResponseEntity<SuppliersEntities> getSuppliersById(@PathVariable String id) {
        return service.getSuppliersById(id);
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<SuppliersEntities> createSupplier(@RequestBody SuppliersEntities supplier) {
        return service.createSupplier(supplier);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<SuppliersEntities> updateSupplier(@RequestBody SuppliersEntities supplier) {
        return service.updateSupplier(supplier);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupplier(@PathVariable String id) {
        return service.deleteSupplier(id);
    }
}
