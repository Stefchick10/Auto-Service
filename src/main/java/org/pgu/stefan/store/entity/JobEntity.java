package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class JobEntity {

  @Id
  @GeneratedValue
  private Long id;

  private ZonedDateTime startedAt;
  private ZonedDateTime finishedAt;

  private Double priceRubles;

  @ManyToOne(optional = false)
  private ServiceEntity service;

  @ManyToOne(optional = false)
  private CarEntity car;
}