package com.afra.services.suppliers;

import com.afra.entities.DepartmentsEntities;
import com.afra.entities.ResourceEntities;
import com.afra.entities.SuppliersEntities;
import com.afra.repository.SupplierRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepo repo;

    @Override
    public ResponseEntity<List<SuppliersEntities>> getAllSuppliers() {
        try{
           List<SuppliersEntities> result = IterableUtils.toList(repo.findAll());
           return new ResponseEntity<List<SuppliersEntities>>(result, HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<SuppliersEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SuppliersEntities> getSuppliersById(String id) {
        try {
            SuppliersEntities result = repo.findByResourceFk(id);
            if(result != null){
                return new ResponseEntity<SuppliersEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<SuppliersEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SuppliersEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SuppliersEntities> createSupplier(SuppliersEntities supplier) {
        try {
            SuppliersEntities result = repo.findByResourceFk(supplier.getResourceFk());
            if(result == null){
                repo.save(supplier);
                return new ResponseEntity<SuppliersEntities>(supplier, HttpStatus.OK);
            }else {
                return new ResponseEntity<SuppliersEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SuppliersEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SuppliersEntities> updateSupplier(SuppliersEntities supplier) {
        try {
            SuppliersEntities result = repo.findByResourceFk(supplier.getResourceFk());
            if(result != null){
                result.setName(supplier.getName());
                repo.save(result);
                return new ResponseEntity<SuppliersEntities>(supplier, HttpStatus.OK);
            }else {
                return new ResponseEntity<SuppliersEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SuppliersEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteSupplier(String id) {
        return null;
    }
}
