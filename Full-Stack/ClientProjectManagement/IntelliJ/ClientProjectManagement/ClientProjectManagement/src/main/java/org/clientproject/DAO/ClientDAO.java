package org.clientproject.DAO;

import org.clientproject.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {


}