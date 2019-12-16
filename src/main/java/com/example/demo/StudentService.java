package com.example.demo;


import com.example.demo.db.ScoreRepository;
import com.example.demo.db.ScoreRow;
import com.example.demo.db.StudentRepository;
import com.example.demo.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    List<Student> getStudents() {
        return List.ofAll(this.studentRepository.findAll())
                .map(StudentRow::toStudent
                );

    }

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c -> {
            c.setNumer(newNumber);
            studentRepository.save(c);
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
        return this.studentRepository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa)).toStudent();
    }

    public Optional<Integer> addScore(final long studentId, final Score score){
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c->{
            int existingScore=List.ofAll(c.getScores())
                    .foldLeft(0,(p,s)->p+s.getScore());
            final ScoreRow newScore=new ScoreRow(score.score,score.comment,c);
            this.scoreRepository.save(newScore);
            return existingScore+score.score;});

    }

}
