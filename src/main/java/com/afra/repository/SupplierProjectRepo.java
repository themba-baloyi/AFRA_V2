package com.afra.repository;

import com.afra.entities.SupplierProjectEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierProjectRepo extends CrudRepository<SupplierProjectEntities, Long> {
    List<SupplierProjectEntities> findAllByProjectFk(String projectFk);
    List<SupplierProjectEntities> findAllBySupplierFk(String supplierFk);
    SupplierProjectEntities findByProjectFkAndSupplierFk(String projectFk, String supplierFk);
    void deleteByProjectFkAndSupplierFk(String projectFk, String supplierFk);
}
