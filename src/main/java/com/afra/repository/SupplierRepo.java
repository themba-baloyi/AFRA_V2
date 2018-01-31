package com.afra.repository;

import com.afra.entities.SuppliersEntities;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<SuppliersEntities, String> {
    public SuppliersEntities findByResourceFk(String resourceFk);
}
