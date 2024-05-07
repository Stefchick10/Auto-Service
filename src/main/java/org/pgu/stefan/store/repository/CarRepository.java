package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
