package edu.ccrm.service;

/**
 * Service class for handling all business logic related to student enrollments.
 */
public class EnrollmentService {

    private final StudentService studentService;
    private final CourseService courseService;

    /**
     * Constructor that requires the other services to function.
     * This is a form of dependency injection.
     * @param studentService The shared student service instance.
     * @param courseService The shared course service instance.
     */
    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Enrollment logic methods will be added here later.
    // For example: public void enrollStudentInCourse(String studentRegNo, String courseCode) { ... }
}

