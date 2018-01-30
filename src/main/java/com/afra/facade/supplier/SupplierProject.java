package com.afra.facade.supplier;

import com.afra.entities.SupplierProjectEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierProject {
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierProject();
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierByProject(String projectId);
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierBySupplier(String supplierId);
    ResponseEntity<SupplierProjectEntities> getSupplierProject(String supplierId, String projectId);
    ResponseEntity<SupplierProjectEntities> createSupplierProject(SupplierProjectEntities data);
    ResponseEntity<SupplierProjectEntities> updateSupplierProject(SupplierProjectEntities data);
    ResponseEntity deleteSupplierProject(String projectId, String supplierId);
}
