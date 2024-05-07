package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "masters", path = "masters")
public interface MasterRepository extends JpaRepository<MasterEntity, Long> {

}
