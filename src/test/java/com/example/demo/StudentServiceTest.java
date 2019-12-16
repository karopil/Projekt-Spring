package com.example.demo;

import com.example.demo.db.ScoreRepository;
import com.example.demo.db.StudentRepository;
import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ScoreRepository scoreRepository;


    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

/*    @Test
    //test1
    public void getEmptyList() {
        final StudentService service = new StudentService(repository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
*/

    @Test
    //test2
    public void addStudent() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);

    }

    @Test
    //test3
    public void addStudentIsReturned() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.get(0).name);

    }

    @Test
    //test4
    public void addStudentHasNewId() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created1 = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "4-5-6", "IP"));
        assertNotEquals(created1.id, created2.id);
        assertEquals(2,service.getStudents().size());
    }

    @Test
    //test5
    public void getEmptyList() {
        final StudentService service = new StudentService(repository, scoreRepository);
    }
}