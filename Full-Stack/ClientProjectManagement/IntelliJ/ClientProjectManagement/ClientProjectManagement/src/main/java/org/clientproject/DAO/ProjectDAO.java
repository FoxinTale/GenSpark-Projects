package org.clientproject.DAO;

import org.clientproject.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDAO extends JpaRepository<ProjectEntity, Integer> {


}