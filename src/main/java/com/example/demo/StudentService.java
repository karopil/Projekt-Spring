package com.example.demo;

import io.vavr.collection.List;

public class StudentService {

    private List<Student> students = List.empty();


    List<Student> getStudents() {
        return students;
    }

    Student addStudent(NewStudent n_Student) {
        Student created = new Student((students.size() + 1), n_Student.name, n_Student.numer, n_Student.grupa);
        students = students.prepend(created);

        return created;
    }


}
