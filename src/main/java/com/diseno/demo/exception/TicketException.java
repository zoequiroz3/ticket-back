package com.diseno.demo.exception;

import lombok.Getter;

@Getter
public class TicketException extends RuntimeException {
    private final String code;

    public TicketException(String message, String code) {
        super(message);
        this.code = code;
    }

    public TicketException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
