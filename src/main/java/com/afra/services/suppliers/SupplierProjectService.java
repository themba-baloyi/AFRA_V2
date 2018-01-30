package com.afra.services.suppliers;

import com.afra.entities.SupplierProjectEntities;
import com.afra.models.SupplierProjectModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierProjectService {
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierProject();
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierByProject(String projectId);
    ResponseEntity<List<SupplierProjectEntities>> getAllSupplierBySupplier(String supplierId);
    ResponseEntity<SupplierProjectEntities> getSupplierProject(String supplierId, String projectId);
    ResponseEntity<SupplierProjectEntities> createSupplierProject(SupplierProjectEntities data);
    ResponseEntity<SupplierProjectEntities> updateSupplierProject(SupplierProjectEntities data);
    ResponseEntity deleteSupplierProject(String projectId, String supplierId);

}
