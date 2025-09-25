package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import edu.ccrm.exception.ResourceNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();
    private static final String COURSES_FILE_PATH = "data/courses.csv";

    public CourseService() {
        loadCoursesFromFile();
    }

    private void loadCoursesFromFile() {
        Path path = Paths.get(COURSES_FILE_PATH);
        if (!Files.exists(path)) {
            System.err.println("FATAL ERROR: Course data file not found at " + path.toAbsolutePath());
            System.err.println("Please ensure the 'data' directory with 'courses.csv' exists at the root of your project.");
            return;
        }
        try {
            List<Course> loadedCourses = Files.lines(path)
                .map(line -> {
                    try {
                        // Assuming CSV format: code,title,credits,instructor,semester,department
                        String[] parts = line.split(",");
                        if (parts.length != 6) {
                            System.err.println("WARNING: Skipping malformed line in courses.csv: " + line);
                            return null; // Skip this line
                        }
                        return new Course.CourseBuilder(parts[0].trim(), parts[1].trim())
                            .credits(Integer.parseInt(parts[2].trim()))
                            .instructor(parts[3].trim())
                            .semester(Semester.valueOf(parts[4].trim().toUpperCase()))
                            .department(parts[5].trim())
                            .build();
                    } catch (Exception e) {
                        System.err.println("WARNING: Could not parse line in courses.csv: '" + line + "'. Error: " + e.getMessage());
                        return null; // Skip this line
                    }
                })
                .filter(Objects::nonNull) // Filter out any lines that failed to parse
                .collect(Collectors.toList());
                
            courses.addAll(loadedCourses);

        } catch (IOException e) {
            System.err.println("FATAL ERROR: Could not read courses file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listAllCourses() {
        System.out.println("\n--- List of All Courses ---");
        if (courses.isEmpty()) {
            System.out.println("No courses found. Check for errors above regarding file loading.");
        } else {
            courses.forEach(c -> System.out.println(c.toString() + "\n"));
        }
    }

    public Course findCourseByCode(String courseCode) throws ResourceNotFoundException {
        return courses.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(courseCode))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Course with code '" + courseCode + "' not found."));
    }

    public List<Course> searchCourses(Predicate<Course> predicate) {
        return courses.stream().filter(predicate).collect(Collectors.toList());
    }
}
