package com.afra.repository;

import com.afra.entities.ResourceWorkEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResourceWorkRepo extends CrudRepository<ResourceWorkEntities, Long> {
    List<ResourceWorkEntities> findAllByProjectFk(String projectFk);
    List<ResourceWorkEntities> findAllByResourceFk(String resourceFk);
    ResourceWorkEntities findByProjectFkAndResourceFk(String projectFk, String resourceFk);
    void deleteByProjectFkAndResourceFk(String projectFk, String resourceFk);
}
