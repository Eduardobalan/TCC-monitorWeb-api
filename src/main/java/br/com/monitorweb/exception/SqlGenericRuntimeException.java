package br.com.monitorweb.exception;

/**
 * Created by Eduardo Balan on 30/06/2017.
 */
public class SqlGenericRuntimeException extends GenericRuntimeException {

    private static final long serialVersionUID = -992023069943994640L;

    public SqlGenericRuntimeException(Exception e) {
        super(e.getMessage(), e.getCause());
    }

    public String getMessage() {
        return "Exception DB -> "+super.getMessage();
    }

}
