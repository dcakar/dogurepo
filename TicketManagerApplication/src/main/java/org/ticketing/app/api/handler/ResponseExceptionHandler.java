package org.ticketing.app.api.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = {RestController.class})
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
}
