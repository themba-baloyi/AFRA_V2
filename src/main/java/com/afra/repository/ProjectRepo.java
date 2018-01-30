package com.afra.repository;

import com.afra.entities.ProjectsEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CrudRepository<ProjectsEntities, String> {

}
