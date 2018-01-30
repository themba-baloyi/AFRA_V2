package com.afra.repository;

import com.afra.entities.ProjectHoursEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectHourRepo extends CrudRepository<ProjectHoursEntities, Long> {
    ProjectHoursEntities findByProjectFk(String projectId);
}
