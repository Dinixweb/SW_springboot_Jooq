package io.spielworksbackend.SpielworksBackendAssessment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@ResponseBody
public class globalErroHandler {

        /**
         * This will handle IndexOutOfBoundsExceptions
         * it will only return statusCode without body
         * */
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(IndexOutOfBoundsException.class)
        public void handleNoTFound() {}

        /**
         * This will handle IndexOutOfBoundsExceptions
         * it will only return statusCode without body
         * */
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(ClassNotFoundException.class)
        public void handleBadRequest() {}
}
