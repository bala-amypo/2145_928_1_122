package com.example.demo.exception;

/**
 * Custom exception for resource not found scenarios.
 * Used across services and controllers.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
