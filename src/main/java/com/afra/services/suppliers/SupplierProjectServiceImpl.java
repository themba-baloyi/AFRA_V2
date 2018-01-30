package com.afra.services.suppliers;

import com.afra.entities.SupplierProjectEntities;
import com.afra.repository.SupplierProjectRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class SupplierProjectServiceImpl implements SupplierProjectService {

    @Autowired
    SupplierProjectRepo repo;


    @Override
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierProject() {
        try{
            List<SupplierProjectEntities> result = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<SupplierProjectEntities>>(result, HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<SupplierProjectEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierByProject(String projectId) {
        try{
            List<SupplierProjectEntities> result = IterableUtils.toList(repo.findAllByProjectFk(projectId));
            if(result != null){
                return new ResponseEntity<List<SupplierProjectEntities>>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<List<SupplierProjectEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<SupplierProjectEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<SupplierProjectEntities>> getAllSupplierBySupplier(String supplierId) {
        try{
            List<SupplierProjectEntities> result = IterableUtils.toList(repo.findAllBySupplierFk(supplierId));

            if(result != null){
                return new ResponseEntity<List<SupplierProjectEntities>>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<List<SupplierProjectEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<SupplierProjectEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SupplierProjectEntities> getSupplierProject(String supplierId, String projectId) {
        try{
            SupplierProjectEntities result = repo.findByProjectFkAndSupplierFk(projectId, supplierId);
            if(result != null){
                return new ResponseEntity<SupplierProjectEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<SupplierProjectEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SupplierProjectEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SupplierProjectEntities> createSupplierProject(SupplierProjectEntities data) {
        try{
            SupplierProjectEntities result = repo.findByProjectFkAndSupplierFk(data.getProjectFk(), data.getSupplierFk());
            if(result == null){
                repo.save(data);
                return new ResponseEntity<SupplierProjectEntities>(data, HttpStatus.OK);
            }else {
                return new ResponseEntity<SupplierProjectEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SupplierProjectEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<SupplierProjectEntities> updateSupplierProject(SupplierProjectEntities data) {
        try{
            SupplierProjectEntities result = repo.findByProjectFkAndSupplierFk(data.getProjectFk(), data.getSupplierFk());
            if(result != null){
                repo.save(data);
                return new ResponseEntity<SupplierProjectEntities>(data, HttpStatus.OK);
            }else {
                return new ResponseEntity<SupplierProjectEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SupplierProjectEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteSupplierProject(String projectId, String supplierId) {
        try{
            SupplierProjectEntities result = repo.findByProjectFkAndSupplierFk(projectId, supplierId);
            if(result != null){
                repo.deleteByProjectFkAndSupplierFk(projectId, supplierId);
                return new ResponseEntity<SupplierProjectEntities>(HttpStatus.OK);
            }else {
                return new ResponseEntity<SupplierProjectEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<SupplierProjectEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
