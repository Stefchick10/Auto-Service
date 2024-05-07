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
public class ListServicesEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String price;


    @OneToOne(mappedBy = "job")
    private List<JobEntity> job;

}