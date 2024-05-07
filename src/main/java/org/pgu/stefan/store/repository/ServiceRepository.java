package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

}
