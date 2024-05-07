package org.pgu.stefan.store.repository;

import org.pgu.stefan.store.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
