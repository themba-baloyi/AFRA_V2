package com.afra.repository;

import com.afra.entities.ProjectFinanceEntities;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectFinanceRepo extends CrudRepository<ProjectFinanceEntities, Long> {

    ProjectFinanceEntities findByProjectFk(String projectFk);
    boolean deleteByProjectFk(String projectFk);

    @Transactional
    @Modifying
    @Query(value = "update finance_project set act_cost = :actCost, est_cost = :estCost  where project_fk = :projectFk", nativeQuery = true)
    void updateProjectFinance(@Param(value = "actCost") double actCost, @Param(value = "estCost") double estCost, @Param(value = "projectFk") String projectFk);

}
