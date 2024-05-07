package org.pgu.stefan.api.controller.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {

  String error;

  @JsonProperty("error_description")
  String errorDescription;

  @JsonProperty("error_code")
  String errorCode;
}