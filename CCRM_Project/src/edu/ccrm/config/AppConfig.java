package edu.ccrm.config;

import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.StudentService;

/**
 * Singleton class for application-wide configuration and service access.
 * This ensures that there is only one instance of each service.
 */
public final class AppConfig {

    private static final AppConfig INSTANCE = new AppConfig();

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    /**
     * Private constructor to prevent instantiation from outside.
     * It initializes all the services for the application.
     */
    private AppConfig() {
        // Initialize services in the correct order of dependency
        studentService = new StudentService();
        courseService = new CourseService();
        enrollmentService = new EnrollmentService(studentService, courseService);
    }

    /**
     * Returns the single instance of the AppConfig class.
     * @return The singleton AppConfig instance.
     */
    public static AppConfig getInstance() {
        return INSTANCE;
    }

    // --- Service Getters (These were missing) ---

    public StudentService getStudentService() {
        return studentService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public EnrollmentService getEnrollmentService() {
        return enrollmentService;
    }
}
