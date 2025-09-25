package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.exception.ResourceNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private static final String STUDENTS_FILE_PATH = "data/students.csv";

    public StudentService() {
        loadStudentsFromFile();
    }

    private void loadStudentsFromFile() {
        Path path = Paths.get(STUDENTS_FILE_PATH);
        if (!Files.exists(path)) {
            System.err.println("FATAL ERROR: Student data file not found at " + path.toAbsolutePath());
            return;
        }
        try {
            students.addAll(Files.lines(path).map(line -> {
                try {
                    // Expecting format: S-ID,RegNo,FullName,Email,Status,Date
                    String[] parts = line.split(",");
                    if (parts.length < 5) { // Loosened to 5 for flexibility
                        System.err.println("WARNING: Skipping malformed line in students.csv: " + line);
                        return null;
                    }
                    // Extracting the correct parts
                    String regNo = parts[1].trim();
                    String fullName = parts[2].trim();
                    String email = parts[3].trim();
                    Student.StudentStatus status = Student.StudentStatus.valueOf(parts[4].trim().toUpperCase());
                    
                    return new Student(regNo, fullName, email, status);
                } catch (Exception e) {
                    System.err.println("WARNING: Could not parse line in students.csv: '" + line + "'. Error: " + e.getMessage());
                    return null;
                }
            })
            .filter(Objects::nonNull) // Filter out any lines that failed to parse
            .collect(Collectors.toList()));
        } catch (IOException e) {
            System.err.println("FATAL ERROR: Could not read students file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listAllStudents() {
        System.out.println("\n--- List of All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students found. Check for parsing errors above.");
        } else {
            students.forEach(s -> System.out.println(s.getProfile() + "\n"));
        }
    }

    public void addStudent(String fullName) {
        // This constructor will auto-generate a new registration number
        Student newStudent = new Student(fullName);
        students.add(newStudent);
        System.out.println("\nSuccessfully added new student:");
        System.out.println(newStudent.getProfile());
    }

    public Student findStudentByRegNo(String regNo) throws ResourceNotFoundException {
        // Use the registration number from the CSV (parts[1])
        return students.stream()
            .filter(s -> s.getRegNo().equalsIgnoreCase(regNo))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Student with Registration Number '" + regNo + "' not found."));
    }
}
