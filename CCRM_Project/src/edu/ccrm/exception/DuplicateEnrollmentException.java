package edu.ccrm.exception;

// Checked exception for when a student tries to enroll in a course twice.
public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
}

