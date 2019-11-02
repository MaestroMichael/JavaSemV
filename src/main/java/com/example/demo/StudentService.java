package com.example.demo;


import io.vavr.collection.List;

public class StudentService {

    List<Student> getStudents() {
        return List.empty();
    }

    Student addStudent(NewStudent n_Student) {
        return new Student(1,"aa","aa","aa");

    }

    private List<Student> students = List.empty();


}
