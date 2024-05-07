package org.pgu.stefan.api.controller.error;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
public class DefaultErrorController implements ErrorController {

  public static final String PATH = "/error";

  ErrorAttributes errorAttributes;

  public String getErrorPath() {
    return PATH;
  }

  @RequestMapping(PATH)
  public ResponseEntity<ErrorDto> error(WebRequest webRequest) {

    String errorCode = (String) webRequest.getAttribute(
        RestException.ERROR_CODE_ATTRIBUTE_NAME,
        RestException.ERROR_CODE_SCOPE
    );

    if (Objects.nonNull(errorCode)) {
      webRequest.removeAttribute(RestException.ERROR_CODE_ATTRIBUTE_NAME, RestException.ERROR_CODE_SCOPE);
    }

    Map<String, Object> attributes = errorAttributes.getErrorAttributes(
        webRequest,
        ErrorAttributeOptions.of(ErrorAttributeOptions.Include.EXCEPTION, ErrorAttributeOptions.Include.MESSAGE)
    );

    HttpStatus httpStatus = Optional
        .ofNullable(errorAttributes.getError(webRequest))
        .map(exception -> HttpStatus.UNAUTHORIZED)
        .orElseGet(() -> HttpStatus.valueOf((Integer) attributes.get("status")));

    return ResponseEntity
        .status(httpStatus.value())
        .body(
            ErrorDto.builder()
                .error(httpStatus.getReasonPhrase())
                .errorDescription((String) attributes.get("message"))
                .errorCode(errorCode)
                .build()
        );
  }
}