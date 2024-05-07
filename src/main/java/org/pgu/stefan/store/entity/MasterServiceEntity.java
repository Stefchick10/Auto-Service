package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master_service")
public class MasterServiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private MasterEntity master;

    @ManyToOne(optional = false)
    private ServiceEntity service;

    private Long workDurationSeconds;

    private Double priceRubles;
}
