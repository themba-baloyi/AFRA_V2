package com.afra.repository;

import com.afra.entities.ProjectResourcesEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProjectResourceRepo extends CrudRepository<ProjectResourcesEntities, Long> {
    List<ProjectResourcesEntities> findAllByResourceFk(String resourceFk);
    List<ProjectResourcesEntities> findAllByProjectFk(String projectFk);
    ProjectResourcesEntities findByProjectFkAndResourceFk(String resourceFk, String projectFk);
    void deleteByProjectFkAndResourceFk(String projectFk, String resourceFk);
}
