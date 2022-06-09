package br.com.codecode.workix.rest.dto.out;

public class Subscribe {
    public boolean subscribed;
    public String message;

    public Subscribe(boolean subscribed, String message) {
        this.subscribed = subscribed;
        this.message = message;
    }
}
