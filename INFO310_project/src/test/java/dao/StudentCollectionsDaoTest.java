/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Student;
import domain.User;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Jayden
 */
public class StudentCollectionsDaoTest {

    StudentDao studentDao;
    UserDao userDao;

    private Student student1;
    private Student student2;
    private Student student3;
    private User user1;
    private User user2;
    private User user3;

    @BeforeAll
    public static void initialise() {
        JDBIDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }

    @BeforeEach
    public void setUp() {
        studentDao = JDBIDaoFactory.getStudentDao();
        userDao = JDBIDaoFactory.getUserDao();

        user1 = new User();
        user1.setEmail("smigr123@otago.ac.nz");
        user1.setPassword("mathsiscool23");

        user2 = new User();
        user2.setEmail("jonbo234@otago.ac.nz");
        user2.setPassword("biologyrocks123");

        user3 = new User();
        user3.setEmail("leest567@otago.ac.nz");
        user3.setPassword("physicsisfun123");

        userDao.saveUser(user1);
        userDao.saveUser(user2);
        userDao.saveUser(user3);

        student1 = new Student();
        student1.setStudentID("smigr123");
        student1.setFirstName("Greg");
        student1.setLastName("Smith");
        student1.setInterests("Mathematics");
        student1.setDescription("PhD Student in Mathematics");
        student1.setPhoneNumber("0223861135");
        student1.setGpa(3.1);
        student1.setAddress("123 George Street");
        student1.setUser(user1);

        student2 = new Student();
        student2.setStudentID("jonbo234");
        student2.setFirstName("Bob");
        student2.setLastName("Jones");
        student2.setInterests("Biology");
        student2.setDescription("PhD Student in Biology");
        student2.setPhoneNumber("0217432651");
        student2.setGpa(4.0);
        student2.setAddress("123 Castle Street");
        student2.setUser(user2);

        student3 = new Student();
        student3.setStudentID("leest567");
        student3.setFirstName("Stacy");
        student3.setLastName("Lee");
        student3.setInterests("Physics");
        student3.setDescription("PhD Student in Physics");
        student3.setPhoneNumber("0274653232");
        student3.setGpa(3.5);
        student3.setAddress("123 Grange Street");
        student3.setUser(user3);

        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
    }

    @AfterEach
    public void tearDown() {
        studentDao.deleteStudentByID(student1.getStudentID());
        studentDao.deleteStudentByID(student2.getStudentID());
        studentDao.deleteStudentByID(student3.getStudentID());

        userDao.deleteUser(user1.getEmail());
        userDao.deleteUser(user2.getEmail());
        userDao.deleteUser(user3.getEmail());
    }

    /**
     * Test adding a student to the DAO and Database
     */
    @Test
    public void testSaveStudent() {
        //Add Student
        studentDao.saveStudent(student3);
        //Check that there are now 3 students in database
        assertThat(studentDao.getStudents(), hasSize(3));
        //Make sure it contains all student objects
        assertThat(studentDao.getStudents(), hasItems(student1, student2, student3));

        //Make Duplicate student 
        final Student student4 = student3;
        // Try adding student4, make sure it throws exception due to duplicate values
        assertThrows(Exception.class, () -> {
            studentDao.saveStudent(student4);
        });

    }

    /**
     * Test getting a list of all students on record
     */
    @Test
    public void testGetStudents() {
        // Make sure it returns the two students on the database
        assertThat(studentDao.getStudents(), hasItems(student1, student2));
        //Make sure it only has those two
        assertThat(studentDao.getStudents(), hasSize(2));
    }

    /**
     * Test to get a student by their specific ID
     */
    @Test
    public void testGetStudentByID() {
        //Get the student by their ID
        Student testStudent = studentDao.getStudentByID(student1.getStudentID());
        //Make sure the returned student is the one specified by the ID
        assertThat(testStudent, is(student1));
        //Make sure the returned student is not being mistakingly recognised
        assertThat(testStudent, not(is(student2)));
    }

    /**
     * Test to delete a student specified by their ID
     */
    @Test
    public void testDeleteStudentByID() {
        //Delete student by their ID
        studentDao.deleteStudentByID(student1.getStudentID());
        //Make sure the student is no longer on record
        assertThat(studentDao.getStudents(), not(hasItem(student1)));
        //Should only be one student on record if succesful
        assertThat(studentDao.getStudents(), hasSize(1));

    }

    /**
     * Test of updateStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testUpdateStudentByID() {
        //Create a clone of Student1 to update
        Student updateStudent = new Student();
        updateStudent.setStudentID("smigr123");
        updateStudent.setFirstName("Greg");
        updateStudent.setLastName("Smith");
        updateStudent.setPhoneNumber("0223861135");
        updateStudent.setAddress("123 George Street");
        updateStudent.setDescription("PhD Student Majoring in Mathematics");
        updateStudent.setInterests("Mathematics");
        updateStudent.setUser(user1);
        //update values
        updateStudent.setGpa(5.0);

        //Make sure its not the old value
        assertThat(student1.getGpa(), not(5.0));
        //Call update method
        studentDao.updateStudentByID(student1.getStudentID(), updateStudent);

        //Make sure the details have updated, get new student
        Student newStudent = studentDao.getStudentByID(student1.getStudentID());
        assertThat(newStudent.getGpa(), is(5.0));

    }

}
