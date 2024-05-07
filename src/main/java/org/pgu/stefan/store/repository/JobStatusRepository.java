package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.ClientEntity;
import org.pgu.stefan.store.entity.JobStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "job-statuses", path = "job-statuses")
public interface JobStatusRepository extends JpaRepository<JobStatusEntity, Long> {

}
