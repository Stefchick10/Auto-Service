package org.pgu.stefan.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DeclareMasterEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String branch;

    private String experience;

    @JsonIgnore
    @ManyToOne
    private MasterEntity master;

    @ManyToOne
    private JobEntity job;


}