/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Student;
import domain.User;
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
    StudentDao dao = JDBIDaoFactory.getStudentDao();
    
    private Student student1;
    private Student student2; 
    private User user1;
    private User user2;
    @BeforeEach
    public void setUp() {
        user1 = new User();
        user1.setEmail("gmsith@gmail.com");
        user1.setPassword("smithg123");
        
        user2 = new User();
        user2.setEmail("bjones@gmail.com");
        user2.setPassword("jonesb123");
        
        student1 = new Student();
        student1.setStudentID("1234");
        student1.setFirstName("Greg");
        student1.setLastName("Smith");
        student1.setInterests("Mathematics");
        student1.setDescription("PhD Student in Mathematics");
        student1.setPhoneNumber("0223861135");
        student1.setGpa(3.1);
        student1.setAddress("123 George Street");
        student1.setUser(user1);
                
        student2 = new Student();
        student2.setStudentID("1235");
        student2.setFirstName("Bob");
        student2.setLastName("Jones");
        student2.setInterests("Biology");
        student2.setDescription("PhD Student in Biology");
        student2.setPhoneNumber("0217432651");
        student2.setGpa(4.0);
        student2.setAddress("123 Castle Street");
        student2.setUser(user2);
    }
    
    @AfterEach
    public void tearDown() {
        dao.deleteStudentByID(student1.getStudentID());
        dao.deleteStudentByID(student2.getStudentID());
    }

    /**
     * Test of saveStudent method, of class StudentCollectionsDao.
     */
    @Test
    public void testSaveStudent() {

    }

    /**
     * Test of getStudents method, of class StudentCollectionsDao.
     */
    @Test
    public void testGetStudents() {
        
      
    }

    /**
     * Test of getStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testGetStudentByID() {

      
    }

    /**
     * Test of deleteStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testDeleteStudentByID() {

    }

    /**
     * Test of updateStudentByID method, of class StudentCollectionsDao.
     */
    @Test
    public void testUpdateStudentByID() {

    }
    
}
