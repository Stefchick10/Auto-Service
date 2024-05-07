package org.pgu.stefan.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListServicesEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String price;

    @OneToOne(mappedBy = "job")
    private JobEntity job;

}