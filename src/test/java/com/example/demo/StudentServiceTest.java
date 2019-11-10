package com.example.demo;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StudentServiceTest {

    @Test
    //test1
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    //test2
    public void addStudent() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);
    }

    @Test
    //test3
    public void addStudentIsReturned() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.get(0).name);

    }

    @Test
    //test4
    public void addStudentHasNewId() {
        final StudentService service = new StudentService();
        final Student created1 = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "4-5-6", "IP"));
        assertNotEquals(created1.id, created2.id);
        assertEquals(2,service.getStudents().size());
    }

}