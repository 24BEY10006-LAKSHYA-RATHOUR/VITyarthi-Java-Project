# **Campus Course & Records Manager (CCRM)**

## **1\. Project Overview**

The Campus Course & Records Manager (CCRM) is a console-based Java application designed to meet the administrative needs of an educational institution. It provides a command-line interface (CLI) for managing student records, course catalogs, and enrollments. The project is built entirely in Java SE and demonstrates a wide range of core and advanced language features, from Object-Oriented Programming (OOP) principles to modern file I/O with NIO.2 and the use of design patterns like the Singleton and Builder.

### **Core Features Implemented**

* **Student Management:** Load students from a CSV file, view a list of all students, and add new students.  
* **Course Management:** Load course data from a CSV file and view a complete list of available courses.  
* **Data Persistence:** Application state (students and courses) is loaded from .csv files at startup.  
* **Robust CLI:** A user-friendly, menu-driven interface for easy navigation and operation.  
* **Centralized Configuration:** Utilizes the Singleton pattern (AppConfig) to manage services and ensure a single source of truth for application data.

## **2\. Project Structure**

The project follows a clean, package-based architecture to separate concerns.

CCRM\_Project/  
|  
|--- src/  
|    └── edu/  
|        └── ccrm/  
|            ├── Main.java  
|            ├── cli/  
|            │   └── CliManager.java  
|            ├── config/  
|            │   └── AppConfig.java  
|            ├── domain/  
|            │   ├── Course.java  
|            │   ├── Enrollment.java  
|            │   ├── Grade.java  
|            │   ├── Instructor.java  
|            │   ├── Person.java  
|            │   ├── Semester.java  
|            │   └── Student.java  
|            ├── exception/  
|            │   ├── DuplicateEnrollmentException.java  
|            │   └── ResourceNotFoundException.java  
|            └── service/  
|                ├── CourseService.java  
|                ├── EnrollmentService.java  
|                └── StudentService.java  
|  
|--- data/  
|    ├── students.csv  
|    └── courses.csv  
|  
└── README.md

## **3\. How to Compile and Run**

To compile and run this project, you will need the Java Development Kit (JDK), version 11 or later.

#### **Steps:**

1. **Open a Command Line / Terminal:** Navigate to the **root folder** of the project (CCRM\_Project/), which contains the src and data directories.  
2. **Compile the Source Code:** Run the following command from the root folder. This compiles all .java files from the src directory and places the output .class files into a bin directory.  
   javac \-d bin src/edu/ccrm/\*\*/\*.java

3. **Run the Application:** Execute the following command from the root folder. The \-cp bin flag tells Java to look for the compiled classes in the bin directory.  
   java \-cp bin edu.ccrm.Main

The application will start, load the data from the CSV files, and display the main menu.

### **Sample Usage**

1. Run the application using the command above.  
2. The main menu will appear.  
3. Enter 1 to go to the Student Management sub-menu.  
4. Enter 1 again to view all students loaded from students.csv.  
5. Enter 0 to return to the main menu.  
6. Enter 2 to go to the Course Management sub-menu.  
7. Enter 1 to view all courses.

## **4\. Technical Demonstrations (Mapping Table)**

This project demonstrates proficiency in the following Java SE concepts as required by the syllabus.

| Concept / Topic | Location in Code (File::Method or Class) |
| :---- | :---- |
| **Core Java** |  |
| Packages & Structure | The entire edu.ccrm package structure |
| Main Entry Point | Main::main |
| switch statement | CliManager::run, CliManager::manageStudents, etc. |
| Loops (while, do-while) | CliManager::run (main application loop) |
| Console Input (Scanner) | CliManager (used throughout for user input) |
| **Object-Oriented Programming** |  |
| Encapsulation (private fields) | All classes in the domain package (e.g., Student, Course) |
| Inheritance (extends) | Student extends Person, Instructor extends Person |
| Abstraction (abstract class) | Person class is abstract with an abstract getProfile() method |
| Polymorphism | CliManager uses Person references for different subtypes |
| toString() Override | Course::toString provides a formatted string representation |
| **Advanced OOP** |  |
| Static Nested Class (Builder) | Course::CourseBuilder |
| Enums with Fields | Grade (with grade points), Semester |
| **Exception Handling** |  |
| try-catch blocks | StudentService::loadStudentsFromFile, CliManager input handlers |
| Custom Exceptions | ResourceNotFoundException, DuplicateEnrollmentException |
| throws keyword | StudentService::findStudentByRegNo, CourseService::findCourseByCode |
| **File I/O (NIO.2)** |  |
| Reading files (Files.lines) | StudentService::loadStudentsFromFile, CourseService::loadCoursesFromFile |
| Path Manipulation (Paths.get) | Used in all service classes to locate data files |
| **Design Patterns** |  |
| Singleton Pattern | AppConfig class ensures only one instance of services |
| Builder Pattern | Course.CourseBuilder for flexible Course object creation |

## **5\. Core Java Concepts Explained**

#### **Java Platform: JDK vs JRE vs JVM**

* **JVM (Java Virtual Machine):** The "actor." It's an abstract machine that executes the compiled Java bytecode. It's what makes Java "write once, run anywhere."  
* **JRE (Java Runtime Environment):** The "stage." It contains the JVM and the core Java libraries needed to *run* Java applications. If you only want to run a Java program, you only need the JRE.  
* **JDK (Java Development Kit):** The "full studio." It contains the JRE, the JVM, and the development tools (like the compiler javac and the debugger) needed to *write* and compile Java applications.

#### **Java Editions: SE vs ME vs EE**

* **Java SE (Standard Edition):** The core Java platform. It's used for developing desktop applications, servers, and console applications like this project. It provides all the fundamental libraries.  
* **Java EE (Enterprise Edition):** Built on top of Java SE. It provides a larger set of APIs for building large-scale, multi-tiered, and reliable enterprise applications (e.g., web services, transactional applications).  
* **Java ME (Micro Edition):** A subset of Java SE designed for resource-constrained devices like mobile phones, sensors, and other embedded systems.

#### **Evolution of Java (Short Timeline)**

* **1995:** Java 1.0 is released by Sun Microsystems.  
* **2004:** Java 5 (J2SE 5.0) is released, introducing major features like generics, annotations, and enums.  
* **2011:** Java 7 is released by Oracle (after acquiring Sun).  
* **2014:** Java 8 is released, a landmark version that introduced Lambda expressions, the Streams API, and a new Date/Time API.  
* **2018:** Java 11 is released as a Long-Term Support (LTS) version.  
* **2021-Present:** Java moves to a faster release cycle, with new LTS versions (like 17 and 21\) released every two years.

## **6\. Setup Screenshots (Placeholders)**

To complete the submission, please insert your own screenshots in the locations specified below.

#### **JDK Installation on Windows**

1. Download the JDK from the Oracle website or an alternative like Adoptium.  
2. Run the installer and follow the on-screen prompts.  
3. Set up the JAVA\_HOME and Path environment variables.  
4. Verify the installation by opening a command prompt and running java \-version.

*\[Your Screenshot Here: The output of the java \-version command in your terminal\]*

#### **Eclipse IDE Setup**

1. Download and install the Eclipse IDE for Java Developers.  
2. Launch Eclipse and create a new workspace.  
3. Go to File \> New \> Java Project.  
4. Give your project a name (e.g., CCRM\_Project).  
5. Right-click the src folder in the Package Explorer and create the necessary packages (e.g., edu.ccrm.cli).  
6. Create your .java class files inside their respective packages.

*\[Your Screenshot Here: The Eclipse IDE showing your CCRM project structure in the Package Explorer\]*
