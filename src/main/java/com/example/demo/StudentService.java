package com.example.demo;


import com.example.demo.db.StudentRepository;
import com.example.demo.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Function;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(StudentRow::toStudent
                );

    }

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student =
                this.repository.findById(studentId);
        return student.map(c -> {
            c.setNumer(newNumber);
            repository.save(c);
            return c.toStudent();
        });
    }




    /*private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumer(),
                        dbObj.getGrupa());
    }*/

    Student addStudent(final NewStudent newStudent) {
        return this.repository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa)).toStudent();
    }

}
