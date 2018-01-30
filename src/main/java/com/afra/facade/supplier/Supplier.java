package com.afra.facade.supplier;

import com.afra.entities.SuppliersEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Supplier {
    ResponseEntity<List<SuppliersEntities>> getAllSuppliers();
    ResponseEntity<SuppliersEntities> getSuppliersById(String id);
    ResponseEntity<SuppliersEntities> createSupplier(SuppliersEntities supplier);
    ResponseEntity<SuppliersEntities> updateSupplier(SuppliersEntities supplier);
    ResponseEntity deleteSupplier(String id);
}
