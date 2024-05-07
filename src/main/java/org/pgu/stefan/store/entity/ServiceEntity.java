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
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String Name;

    private String Address;

    @OneToMany(mappedBy = "service")
    private List<MasterEntity> master;

}