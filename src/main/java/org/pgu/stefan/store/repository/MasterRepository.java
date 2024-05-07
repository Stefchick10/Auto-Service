package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.ClientEntity;
import org.pgu.stefan.store.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<MasterEntity, Long> {

}
