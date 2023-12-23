package com.kingdom.manager.domain.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
    public DatabaseIntegrityException(String message) {
        super(message);
    }
}
