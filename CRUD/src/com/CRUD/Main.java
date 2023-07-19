package com.CRUD;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCRUD studentCRUD = new StudentCRUD();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student newStudent = new Student(id, name, age);
                    studentCRUD.createStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter student ID to read: ");
                    int idToRead = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    String student = studentCRUD.readStudent(idToRead);
                    if (student != null) {
                        System.out.println("Student found:");
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    String existingStudent = studentCRUD.readStudent(idToUpdate);
                    if (existingStudent != null) {
                        System.out.print("Enter updated student name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter updated student age: ");
                        int updatedAge = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        Student updatedStudent = new Student(idToUpdate, updatedName, updatedAge);
                        studentCRUD.updateStudent(updatedStudent);
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    studentCRUD.deleteStudent(idToDelete);
                    System.out.println("Student deleted successfully.");
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


