package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.MasterJobEntity;
import org.pgu.stefan.store.entity.MasterServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "master-jobs", path = "master-jobs")
public interface MasterJobRepository extends JpaRepository<MasterJobEntity, Long> {

}
