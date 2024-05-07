package org.pgu.stefan.store.entity;

import jakarta.persistence.*;
import lombok.*;
import org.pgu.stefan.domain.JobStatus;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_status")
public class JobStatusEntity {

  @Id
  private Long jobId;

  @Enumerated(EnumType.STRING)
  private JobStatus status;

  private Date updatedAt;
}