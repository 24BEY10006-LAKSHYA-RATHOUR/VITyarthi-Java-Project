package edu.ccrm.exception;

// Unchecked exception for when a student or course is not found.
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
