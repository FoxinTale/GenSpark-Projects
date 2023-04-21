package org.clientproject.DAO;

import org.clientproject.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends JpaRepository<TaskEntity, Integer> {


}