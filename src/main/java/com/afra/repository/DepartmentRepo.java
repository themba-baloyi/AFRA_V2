package com.afra.repository;

import com.afra.entities.DepartmentsEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends CrudRepository<DepartmentsEntities, String> {
}
