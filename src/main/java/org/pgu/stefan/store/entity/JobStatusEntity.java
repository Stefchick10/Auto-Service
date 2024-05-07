package org.pgu.stefan.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobStatusEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String cancelled_order;

    private String progress_order;

    private String ready_order;


    @OneToMany(mappedBy = "job")
    private List<JobEntity> job;

}