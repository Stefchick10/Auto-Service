package org.pgu.stefan.api.controller.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.context.request.RequestAttributes;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestException extends RuntimeException {

  public static final String ERROR_CODE_ATTRIBUTE_NAME = "error_code";
  public static final int ERROR_CODE_SCOPE = RequestAttributes.SCOPE_REQUEST;

  String errorCode;

  public RestException(String message) {
    super(message);
  }

  public RestException(String message,
      String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}