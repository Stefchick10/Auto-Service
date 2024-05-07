package org.pgu.stefan.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String model;

    private String vinNumber;

    @JsonIgnore
    @ManyToOne
    private ClientEntity client;

}
