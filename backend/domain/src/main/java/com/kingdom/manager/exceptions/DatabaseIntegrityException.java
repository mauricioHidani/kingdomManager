package com.kingdom.manager.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
    public DatabaseIntegrityException(String message) {
        super(message);
    }
}
