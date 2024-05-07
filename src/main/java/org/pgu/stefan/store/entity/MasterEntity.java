package org.pgu.stefan.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master")
public class MasterEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String firstName;

  private String secondName;

  private String lastName;

  private String phoneNumber;

  private String experience;

  @JsonIgnore
  @ManyToOne(optional = false)
  private CarStationEntity carStation;
}
