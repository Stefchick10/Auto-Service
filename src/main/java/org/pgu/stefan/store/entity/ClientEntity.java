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
public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;


    private String firstName;

    private String secondName;

    private String lastName;

    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<CarEntity> cars;

}
