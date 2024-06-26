package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class ServiceEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
}