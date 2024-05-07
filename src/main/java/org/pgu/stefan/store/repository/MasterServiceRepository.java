package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.MasterServiceEntity;
import org.pgu.stefan.store.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "master-services", path = "master-services")
public interface MasterServiceRepository extends JpaRepository<MasterServiceEntity, Long> {

}
