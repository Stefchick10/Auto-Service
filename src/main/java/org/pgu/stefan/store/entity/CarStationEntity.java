package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_station")
public class CarStationEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String address;

  private String legalAddress;

  @OneToMany(mappedBy = "carStation")
  private List<MasterEntity> masters;

}