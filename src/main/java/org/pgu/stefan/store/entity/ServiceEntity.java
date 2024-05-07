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
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String Name;

    private String Address;

    @OneToMany(mappedBy = "service")
    private List<MasterEntity> master;

}