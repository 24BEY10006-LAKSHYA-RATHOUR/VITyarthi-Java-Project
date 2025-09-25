package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Student extends Person {
    private static final AtomicInteger regNoCounter = new AtomicInteger(2000); // Start new students from a high number
    
    private final String regNo;
    private String email;
    private StudentStatus status;
    private final List<Enrollment> enrollments;

    /**
     * Constructor for creating a brand new student from the CLI.
     * Auto-generates a registration number.
     */
    public Student(String fullName) {
        super(fullName);
        this.regNo = "S" + regNoCounter.incrementAndGet();
        this.email = "N/A";
        this.status = StudentStatus.ACTIVE;
        this.enrollments = new ArrayList<>();
    }
    
    /**
     * Constructor for loading an existing student from a file.
     * This is the constructor that was missing.
     * It uses the data provided from the CSV.
     */
    public Student(String regNo, String fullName, String email, StudentStatus status) {
        super(fullName);
        this.regNo = regNo;
        this.email = email;
        this.status = status;
        this.enrollments = new ArrayList<>();
    }

    @Override
    public String getProfile() {
        return "Student Profile:\n" +
               "  Registration No: " + regNo + "\n" +
               "  Name: " + fullName + "\n" +
               "  Email: " + email + "\n" +
               "  Status: " + status;
    }
    
    public void enrollInCourse(Course course) {
        this.enrollments.add(new Enrollment(course));
    }

    public String getRegNo() { return regNo; }
    public String getEmail() { return email; }
    public StudentStatus getStatus() { return status; }
    public List<Enrollment> getEnrollments() { return Collections.unmodifiableList(enrollments); }
    
    public enum StudentStatus {
        ACTIVE,
        INACTIVE,
        GRADUATED
    }
}
