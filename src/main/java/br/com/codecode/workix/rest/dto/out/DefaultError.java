package br.com.codecode.workix.rest.dto.out;

public class DefaultError {
    public String errorMessage;

    public DefaultError (){}

    public DefaultError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public DefaultError(Exception exception){
        this.errorMessage = exception.getMessage();
    }
}
