package org.pgu.stefan.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String model;

  private String vinNumber;

  private Date releaseDate;

  @JsonIgnore
  @ManyToOne(optional = false)
  private ClientEntity client;

}
