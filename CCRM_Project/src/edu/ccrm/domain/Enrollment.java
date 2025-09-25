package edu.ccrm.domain;

import java.time.LocalDate;

public class Enrollment {
    private final Course course;
    private Grade grade;
    private final LocalDate enrollmentDate;

    public Enrollment(Course course) {
        this.course = course;
        this.grade = Grade.NA; // Default grade
        this.enrollmentDate = LocalDate.now();
    }

    public Course getCourse() {
        return course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
