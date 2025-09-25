package edu.ccrm.domain;

/**
 * Represents an instructor, inheriting from the Person class.
 */
public class Instructor extends Person {
    
    private String department;

    public Instructor(String fullName, String department) {
        super(fullName);
        this.department = department;
    }

    @Override
    public String getProfile() {
        return "Instructor Profile:\n" +
               "  Name: " + fullName + "\n" +
               "  Department: " + department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}