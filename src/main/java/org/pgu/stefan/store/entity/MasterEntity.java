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
public class MasterEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String phoneNumber;

    @JsonIgnore
    @ManyToOne
    private ServiceEntity service;

    @OneToMany(mappedBy = "DeclareMaster")
    private List<DeclareMasterEntity> DeclareMaster;

}
