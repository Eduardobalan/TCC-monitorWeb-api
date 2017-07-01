package br.com.webmonitor.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eduardo Balan on 29/06/2017.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -992023069943994639L;

    public GenericRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
