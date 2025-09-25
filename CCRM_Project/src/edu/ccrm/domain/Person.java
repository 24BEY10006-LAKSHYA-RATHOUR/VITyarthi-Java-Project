package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.UUID;

/**
 * An abstract base class representing a person in the CCRM system.
 * Demonstrates abstraction.
 */
public abstract class Person {

    protected final String id;
    protected String fullName;
    protected String email;
    protected final LocalDate creationDate;

    public Person(String fullName) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.creationDate = LocalDate.now();
    }

    // Abstract method to be implemented by subclasses
    public abstract String getProfile();

    // Getters and Setters (Encapsulation)
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName;
    }
}
