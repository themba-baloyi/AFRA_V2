package com.afra.services.departments;

import com.afra.entities.DepartmentsEntities;
import com.afra.repository.DepartmentRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    DepartmentRepo repo;

    @Override
    public ResponseEntity<List<DepartmentsEntities>> getAllDepartments() {
        try{
            List<DepartmentsEntities> result = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<DepartmentsEntities>>(result, HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<DepartmentsEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DepartmentsEntities> getDepartmentById(String id) {
        try{
            DepartmentsEntities result = repo.findOne(id);
            if (result != null){
                return new ResponseEntity<DepartmentsEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<DepartmentsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<DepartmentsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DepartmentsEntities> createDepartment(DepartmentsEntities department) {
        try{
            if ( repo.findOne(department.getId()) == null){
                repo.save(department);
                return new ResponseEntity<DepartmentsEntities>(department, HttpStatus.OK);
            }else {
                return new ResponseEntity<DepartmentsEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<DepartmentsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DepartmentsEntities> updateDepartment(DepartmentsEntities department) {
        try{
            if ( repo.findOne(department.getId()) != null){
                repo.save(department);
                return new ResponseEntity<DepartmentsEntities>(department, HttpStatus.OK);
            }else {
                return new ResponseEntity<DepartmentsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<DepartmentsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteDepartment(String id) {
        try{
            DepartmentsEntities result = repo.findOne(id);
            if (result != null){
                repo.delete(id);
                return new ResponseEntity<DepartmentsEntities>( HttpStatus.OK);
            }else {
                return new ResponseEntity<DepartmentsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<DepartmentsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

