package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.MasterEntity;
import org.pgu.stefan.store.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "services", path = "services")
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

}
