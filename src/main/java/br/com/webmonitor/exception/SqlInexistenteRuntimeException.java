package br.com.webmonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eduardo Balan on 29/06/2017.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SqlInexistenteRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -892023213069194640L;

    public SqlInexistenteRuntimeException(Exception e) {
        super(e.getMessage(), e.getCause());
    }

    public SqlInexistenteRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlInexistenteRuntimeException(String message) {
        super(message, null);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
