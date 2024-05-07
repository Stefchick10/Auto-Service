package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.CarStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "car-stations", path = "car-stations")
public interface CarStationRepository extends JpaRepository<CarStationEntity, Long> {

}
