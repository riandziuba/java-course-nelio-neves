package com.rdziuba.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource with id " + id + " not found");
    }
}
