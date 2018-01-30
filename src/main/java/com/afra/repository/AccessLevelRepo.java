package com.afra.repository;

import com.afra.entities.AccessLevelsEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepo extends CrudRepository<AccessLevelsEntities, Integer> {

}
