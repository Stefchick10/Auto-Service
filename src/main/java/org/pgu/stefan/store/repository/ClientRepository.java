package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
