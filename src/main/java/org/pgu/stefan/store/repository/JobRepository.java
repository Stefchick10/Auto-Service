package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.JobEntity;
import org.pgu.stefan.store.entity.JobStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "jobs", path = "jobs")
public interface JobRepository extends JpaRepository<JobEntity, Long> {

}
