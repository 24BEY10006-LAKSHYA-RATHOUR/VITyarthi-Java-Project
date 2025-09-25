package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.ResourceNotFoundException;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.StudentService;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Manages the Command Line Interface (CLI) for the CCRM application.
 */
public class CliManager {

    private final Scanner scanner;
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public CliManager() {
        this.scanner = new Scanner(System.in);
        AppConfig config = AppConfig.getInstance();
        this.studentService = config.getStudentService();
        this.courseService = config.getCourseService();
        this.enrollmentService = config.getEnrollmentService();
    }

    public void run() {
        main_loop: while (true) {
            printMainMenu();
            System.out.print("Enter your choice: ");
            int choice = readIntegerInput();

            switch (choice) {
                case 1: manageStudents(); break;
                case 2: manageCourses(); break;
                case 3: manageEnrollment(); break;
                case 4: System.out.println("\nImport/Export & Backup not yet implemented."); break;
                case 0:
                    System.out.println("\nExiting application. Goodbye!");
                    break main_loop;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n--- CCRM Main Menu ---");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollment & Grades");
        System.out.println("4. Import/Export & Backup");
        System.out.println("0. Exit");
    }

    // --- Student Management ---
    private void manageStudents() {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. View All Students");
            System.out.println("2. Add New Student");
            System.out.println("3. Find Student by Registration No");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = readIntegerInput();

            switch (choice) {
                case 1: studentService.listAllStudents(); break;
                case 2: doAddStudent(); break;
                case 3: doFindStudent(); break;
                case 0: return;
                default: System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void doAddStudent() {
        System.out.print("Enter student's full name: ");
        String name = scanner.nextLine();
        studentService.addStudent(name);
    }

    private void doFindStudent() {
        System.out.print("Enter student's registration number (e.g., S1001): ");
        String regNo = scanner.nextLine();
        try {
            Student student = studentService.findStudentByRegNo(regNo);
            System.out.println("\nStudent Found:");
            System.out.println(student.getProfile());
        } catch (ResourceNotFoundException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // --- Course Management ---
    private void manageCourses() {
        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. View All Courses");
            System.out.println("2. Search/Filter Courses");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = readIntegerInput();

            switch (choice) {
                case 1: courseService.listAllCourses(); break;
                case 2: doSearchCourses(); break;
                case 0: return;
                default: System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
    
    private void doSearchCourses() {
        System.out.print("Enter search term (instructor, department, or semester): ");
        String term = scanner.nextLine().toLowerCase();
        
        Predicate<Course> filterByInstructor = c -> c.getInstructor().toLowerCase().contains(term);
        Predicate<Course> filterByDept = c -> c.getDepartment().toLowerCase().contains(term);
        Predicate<Course> filterBySemester = c -> c.getSemester().toString().toLowerCase().contains(term);

        List<Course> results = courseService.searchCourses(filterByInstructor.or(filterByDept).or(filterBySemester));
        
        System.out.println("\n--- Search Results ---");
        if (results.isEmpty()) {
            System.out.println("No courses found matching your criteria.");
        } else {
            results.forEach(c -> System.out.println(c.toString() + "\n"));
        }
    }

    // --- Enrollment Management ---
    private void manageEnrollment() {
        while (true) {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View a Student's Transcript");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = readIntegerInput();

            switch (choice) {
                case 1: doEnrollStudent(); break;
                case 2: doViewTranscript(); break;
                case 0: return;
                default: System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void doEnrollStudent() {
        System.out.print("Enter student's registration number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter course code to enroll in: ");
        String courseCode = scanner.nextLine();
        try {
            enrollmentService.enrollStudent(regNo, courseCode);
            System.out.println("\nEnrollment successful!");
        } catch (ResourceNotFoundException | DuplicateEnrollmentException e) {
            System.out.println("\nEnrollment failed: " + e.getMessage());
        }
    }
    
    private void doViewTranscript() {
        System.out.print("Enter student's registration number: ");
        String regNo = scanner.nextLine();
        try {
            String transcript = enrollmentService.generateTranscript(regNo);
            System.out.println(transcript);
        } catch (ResourceNotFoundException e) {
             System.out.println("\nCould not generate transcript: " + e.getMessage());
        }
    }

    private int readIntegerInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -99; // Return a value that won't match menu options
        }
    }
}
