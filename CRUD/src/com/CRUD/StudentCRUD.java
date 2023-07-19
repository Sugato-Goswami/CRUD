package com.CRUD;

import java.util.ArrayList;
import java.util.List;

public class StudentCRUD {
    private List<Student> students;

    public StudentCRUD() {
        this.students = new ArrayList<>();
    }

    public void createStudent(Student student) {
        students.add(student);
    }

    public String readStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student.toString();
            }
        }
        return null;
    }

    public void updateStudent(Student updatedStudent) {
        int idToUpdate = updatedStudent.getId();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == idToUpdate) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}


