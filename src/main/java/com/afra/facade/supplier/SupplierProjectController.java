package com.afra.facade.supplier;

import com.afra.entities.SupplierProjectEntities;
import com.afra.services.suppliers.SupplierProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/supplier/project")
public class SupplierProjectController implements SupplierProject{


    @Autowired
    SupplierProjectServiceImpl service;

    @CrossOrigin
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierProject() {
        return service.getAllSupplierProject();
    }

    @CrossOrigin
    @Override
    @GetMapping("/byProject/{projectId}")
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierByProject(@PathVariable String projectId) {
        return service.getAllSupplierByProject(projectId);
    }

    @CrossOrigin
    @Override
    @GetMapping("/bySupplier/{supplierId}")
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierBySupplier(@PathVariable String supplierId) {
        return service.getAllSupplierBySupplier(supplierId);
    }

    @CrossOrigin
    @Override
    @GetMapping("/byIds/{supplierId}/{projectId}")
    public ResponseEntity<SupplierProjectEntities> getSupplierProject(@PathVariable String supplierId, @PathVariable String projectId) {
        return null;
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<SupplierProjectEntities> createSupplierProject(@RequestBody SupplierProjectEntities data) {
        return service.createSupplierProject(data);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<SupplierProjectEntities> updateSupplierProject(@RequestBody SupplierProjectEntities data) {
        return service.updateSupplierProject(data);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("/delete/{projectId}/{supplierId}")
    public ResponseEntity deleteSupplierProject(@PathVariable String projectId, @PathVariable String supplierId) {
        return service.deleteSupplierProject(projectId, supplierId);
    }
}
