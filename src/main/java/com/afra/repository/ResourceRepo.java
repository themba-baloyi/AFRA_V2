package com.afra.repository;

import com.afra.entities.ResourceEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends CrudRepository<ResourceEntities, String > {

}
