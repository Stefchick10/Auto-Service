package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "master_job")
public class MasterJobEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private MasterEntity master;

    @ManyToOne(optional = false)
    private JobEntity job;
}
