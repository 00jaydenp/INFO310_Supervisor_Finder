/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Student;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class StudentCollectionsDaoTest {
    
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveStudent method, of class StudentCollectionsDao.
     */
    @Test
    public void testSaveStudent() {
        System.out.println("saveStudent");
        Student student = null;
        StudentCollectionsDao instance = new StudentCollectionsDao();
        instance.saveStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudents method, of class StudentCollectionsDao.
     */
    @Test
    public void testGetStudents() {
        System.out.println("getStudents");
        StudentCollectionsDao instance = new StudentCollectionsDao();
        Collection<Student> expResult = null;
        Collection<Student> result = instance.getStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testGetStudentByID() {
        System.out.println("getStudentByID");
        String id = "";
        StudentCollectionsDao instance = new StudentCollectionsDao();
        Student expResult = null;
        Student result = instance.getStudentByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testDeleteStudentByID() {
        System.out.println("deleteStudentByID");
        String id = "";
        StudentCollectionsDao instance = new StudentCollectionsDao();
        instance.deleteStudentByID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testUpdateStudentByID() {
        System.out.println("updateStudentByID");
        String id = "";
        Student updatedStudent = null;
        StudentCollectionsDao instance = new StudentCollectionsDao();
        instance.updateStudentByID(id, updatedStudent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
