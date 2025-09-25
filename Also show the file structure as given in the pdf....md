# **Campus Course & Records Manager (CCRM)**

## **1\. Project Overview**

The Campus Course & Records Manager (CCRM) is a console-based Java SE application designed for an educational institute to manage its core academic operations. It provides a command-line interface (CLI) to handle student records, course catalogs, enrollments, and grading.

This project serves as a comprehensive demonstration of Java SE capabilities, including Object-Oriented Programming (OOP), modern file I/O with NIO.2, the Streams API, the Date/Time API, exception handling, and fundamental design patterns.

### **Key Features:**

* **Student Management:** Add, list, update, and deactivate student profiles.  
* **Course Management:** Manage course details, including search and filter capabilities.  
* **Enrollment & Grading:** Handle student enrollment in courses, record marks, and compute GPAs.  
* **Transcript Generation:** Print detailed academic transcripts for students.  
* **File Operations:** Import and export data from/to CSV files and create timestamped backups.

## **2\. How to Run the Application**

### **Prerequisites**

* **Java Development Kit (JDK):** Version 11 or higher.  
* **An IDE (Optional but Recommended):** Eclipse, IntelliJ IDEA, or VS Code.  
* **Git:** For cloning the repository.

### **Steps to Run**

1. **Clone the Repository:**  
   git clone \<your-repository-link\>  
   cd CCRM

2. Compile the Code:  
   Navigate to the src directory and compile all Java files.  
   \# Navigate to the source directory  
   cd src

   \# Compile all java files  
   javac \-d ../bin edu/ccrm/main/Main.java

3. Run the Application:  
   From the bin directory, run the main class.  
   \# Navigate to the compiled output directory  
   cd ../bin

   \# Run the application  
   java edu.ccrm.main.Main

4. Enable Assertions:  
   To run the program with assertions enabled (as required for demonstrating the assert keyword), use the \-ea flag.  
   java \-ea edu.ccrm.main.Main

## **3\. Project File Structure**

The project follows a standard package-by-feature structure to ensure modularity and separation of concerns.

.  
├── src  
│   └── edu  
│       └── ccrm  
│           ├── cli  
│           │   └── CliManager.java       \# Handles all command-line interactions  
│           ├── config  
│           │   └── AppConfig.java        \# Singleton for application configuration  
│           ├── domain  
│           │   ├── Person.java           \# Abstract base class for Student, Instructor  
│           │   ├── Student.java          \# Student data model  
│           │   ├── Instructor.java       \# Instructor data model  
│           │   ├── Course.java           \# Course data model with Builder pattern  
│           │   ├── Grade.java            \# Enum for grades and grade points  
│           │   └── Semester.java         \# Enum for academic semesters  
│           ├── io  
│           │   └── (File handling classes will go here)  
│           ├── main  
│           │   └── Main.java             \# Main entry point of the application  
│           ├── service  
│           │   ├── StudentService.java   \# Business logic for students  
│           │   ├── CourseService.java    \# Business logic for courses  
│           │   └── EnrollmentService.java \# Business logic for enrollments  
│           └── util  
│               └── (Utility classes will go here)  
├── data  
│   ├── students.csv  
│   └── courses.csv  
└── README.md

## **4\. Core Java Concepts Explained**

### **4.1. Evolution of Java (A Brief Timeline)**

* **1995:** Java 1.0 is released by Sun Microsystems with the "Write Once, Run Anywhere" promise.  
* **1998:** J2SE 1.2 is released, introducing the Swing GUI toolkit and Collections Framework.  
* **2004:** J2SE 5.0 (Tiger) is released, bringing major features like Generics, Enums, Autoboxing, and Annotations.  
* **2011:** Oracle acquires Sun. Java SE 7 is released with features like the Diamond Operator and try-with-resources.  
* **2014:** Java SE 8 marks a revolutionary release with Lambdas, the Stream API, and a new Date/Time API.  
* **2017:** Java SE 9 introduces the Java Platform Module System.  
* **2018:** A new 6-month release cycle begins with Java SE 10 and 11 (LTS).  
* **2021:** Java SE 17 (LTS) is released, bringing records, sealed classes, and pattern matching for instanceof.

### **4.2. Java ME vs. Java SE vs. Java EE**

| Feature | Java ME (Micro Edition) | Java SE (Standard Edition) | Java EE (Enterprise Edition) |
| :---- | :---- | :---- | :---- |
| **Primary Use** | Resource-constrained devices (e.g., mobile, embedded) | Desktop applications, servers, core Java development | Large-scale, distributed, enterprise-level applications |
| **Core API** | A subset of the Java SE API with specific libraries. | The foundational Java platform (core API, JVM, etc.) | Extends Java SE with APIs for web services, servlets, etc. |
| **Example APIs** | javax.microedition.\* | java.lang, java.util, java.io, Swing, JavaFX | Servlets, JSP, EJB, JPA, JSF |
| **Application Type** | Mobile Apps (legacy), Smart Cards, IoT devices. | Console apps, desktop GUI apps, backend services. | Web applications, application servers, microservices. |

### **4.3. Java Architecture: JDK, JRE, JVM**

* **JVM (Java Virtual Machine):** The runtime engine that executes Java bytecode. It is platform-dependent and responsible for memory management, security, and converting bytecode into native machine code. It's the core component that enables Java's "Write Once, Run Anywhere" feature.  
* **JRE (Java Runtime Environment):** The software package that provides the JVM and the necessary Java class libraries to *run* Java applications. It does not contain tools for development like compilers or debuggers. If you only want to run a Java program, you only need the JRE.  
* **JDK (Java Development Kit):** The full-featured software development kit for Java. It includes everything in the JRE, plus development tools such as the compiler (javac), archiver (jar), and debugger (jdb). You need the JDK to *develop* Java applications.

**Interaction:** JDK \> JRE \> JVM. The JDK contains the JRE, and the JRE contains the JVM. A developer writes code and uses the JDK to compile it into bytecode. A user then uses the JRE (with its JVM) to run that bytecode.

## **5\. Setup and Installation Guide (Windows)**

### **5.1. Installing the JDK**

1. **Download:** Go to the official Oracle Java Downloads page or a provider like Adoptium (for Eclipse Temurin).  
2. **Run Installer:** Execute the downloaded installer and follow the on-screen instructions.  
3. **Set Environment Variables:**  
   * Find the JDK installation path (e.g., C:\\Program Files\\Java\\jdk-17).  
   * Set JAVA\_HOME: Create a new environment variable named JAVA\_HOME pointing to this path.  
   * Update Path: Add %JAVA\_HOME%\\bin to the system's Path variable.  
4. Verify Installation: Open a new Command Prompt and run java \-version and javac \-version.  
   \*\*

### **5.2. Setting up Eclipse IDE**

1. **Download:** Get the "Eclipse IDE for Java Developers" from the Eclipse website.  
2. **Launch:** Unzip the downloaded file and run eclipse.exe.  
3. **Create Project:** Go to File \> New \> Java Project.  
4. **Configure:** Give your project a name (e.g., CCRM), select the correct JRE, and click Finish.  
5. Run: Right-click on your Main.java file, then Run As \> Java Application.  
   \*\*

## **6\. Topic to Code Mapping**

| Syllabus Topic | File / Class / Method Where Demonstrated |
| :---- | :---- |
| **Packages** | Project structure (edu.ccrm.cli, edu.ccrm.domain, etc.) |
| **OOP \- Encapsulation** | All classes in edu.ccrm.domain (e.g., Student.java) with private fields. |
| **OOP \- Inheritance** | Student.java and Instructor.java extend Person.java. |
| **OOP \- Abstraction** | Person.java is an abstract class with abstract methods. |
| **OOP \- Polymorphism** | TranscriptService.printTranscript() using Person references. |
| **Design Pattern \- Singleton** | AppConfig.java in edu.ccrm.config. |
| **Design Pattern \- Builder** | Course.java contains a static nested CourseBuilder class. |
| **Interfaces** | Persistable.java, implemented by services. |
| **Enums with Constructors** | Grade.java, Semester.java in edu.ccrm.domain. |
| **Custom Exceptions** | DuplicateEnrollmentException.java, MaxCreditLimitExceededException.java. |
| **File I/O (NIO.2)** | ImportExportService.java, BackupService.java in edu.ccrm.io. |
| **Streams API** | CourseService.searchCourses(), TranscriptService.calculateGPA(). |
| **Lambdas & Functional Interfaces** | CourseService.searchCourses() uses Predicate lambdas for filtering. |
| **Date/Time API** | BackupService.backupData() for timestamped folders; Student creation date. |
| **Recursion** | RecursiveUtil.getDirectorySize() in edu.ccrm.util. |
| **Nested Classes (Static/Inner)** | Course.CourseBuilder (static nested), Anonymous inner class in CliManager. |
| **Assertions (assert)** | EnrollmentService.enrollStudent() to check credit limits. |

