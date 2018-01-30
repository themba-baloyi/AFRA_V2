package com.afra.services.suppliers;

import com.afra.entities.ResourceEntities;
import com.afra.entities.SuppliersEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {
    ResponseEntity<List<SuppliersEntities>> getAllSuppliers();
    ResponseEntity<SuppliersEntities> getSuppliersById(String id);
    ResponseEntity<SuppliersEntities> createSupplier(SuppliersEntities supplier);
    ResponseEntity<SuppliersEntities> updateSupplier(SuppliersEntities supplier);
    ResponseEntity deleteSupplier(String id);
}
