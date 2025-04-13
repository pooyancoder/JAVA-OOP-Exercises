# Student Management System 🎓

## Overview
This is a **Student Management System** built using **OOP principles in Java**. It allows admins to manage student records, enroll students in courses, and track grades.

## Features
- Add and remove students.
- Enroll students in courses.
- Assign and update student grades.

## Classes & Structure
```plaintext
StudentManagementSystem
 ├── Student
 ├── Course
 ├── Admin
 ├── Main (Runner)
```

## Implementation

### `Student.java`
```java
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int studentId;
    private Map<String, Double> grades;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new HashMap<>();
    }

    public void enrollInCourse(String course) {
        grades.put(course, null);
        System.out.println(name + " enrolled in " + course);
    }

    public void assignGrade(String course, double grade) {
        if (grades.containsKey(course)) {
            grades.put(course, grade);
            System.out.println("Grade assigned: " + grade + " in " + course);
        } else {
            System.out.println("Student not enrolled in " + course);
        }
    }

    public void printGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }
}
```

### `Course.java`
```java
public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### `Admin.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Student> students;
    private List<Course> courses;

    public Admin() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student);
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Added course: " + course.getName());
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);

        Course math = new Course("Mathematics");
        Course history = new Course("History");

        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.addCourse(math);
        admin.addCourse(history);

        student1.enrollInCourse("Mathematics");
        student1.assignGrade("Mathematics", 95.5);
        student1.printGrades();
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement student authentication.
- Add a graphical interface for better interaction.
- Include attendance tracking.

---
🎓 **Manage students efficiently!** 📚
