package org.pgu.stefan.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String start_end_date;


    @JsonIgnore
    @ManyToOne
    private JobStatusEntity status;

    @OneToMany(mappedBy = "job")
    private List<DeclareMasterEntity> DeclareMaster;

    @ManyToOne
    private CarEntity car;

}