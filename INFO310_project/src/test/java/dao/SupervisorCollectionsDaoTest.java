/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Supervisor;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class SupervisorCollectionsDaoTest {
    
    public SupervisorCollectionsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSupervisors method, of class SupervisorCollectionsDao.
     */
    @Test
    public void testGetSupervisors() {
        System.out.println("getSupervisors");
        SupervisorCollectionsDao instance = new SupervisorCollectionsDao();
        Collection<Supervisor> expResult = null;
        Collection<Supervisor> result = instance.getSupervisors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupervisorById method, of class SupervisorCollectionsDao.
     */
    @Test
    public void testGetSupervisorById() {
        System.out.println("getSupervisorById");
        String id = "";
        SupervisorCollectionsDao instance = new SupervisorCollectionsDao();
        Supervisor expResult = null;
        Supervisor result = instance.getSupervisorById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSupervisor method, of class SupervisorCollectionsDao.
     */
    @Test
    public void testSaveSupervisor() {
        System.out.println("saveSupervisor");
        Supervisor supervisor = null;
        SupervisorCollectionsDao instance = new SupervisorCollectionsDao();
        instance.saveSupervisor(supervisor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSupervisor method, of class SupervisorCollectionsDao.
     */
    @Test
    public void testUpdateSupervisor() {
        System.out.println("updateSupervisor");
        String id = "";
        Supervisor supervisor = null;
        SupervisorCollectionsDao instance = new SupervisorCollectionsDao();
        instance.updateSupervisor(id, supervisor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSupervisor method, of class SupervisorCollectionsDao.
     */
    @Test
    public void testDeleteSupervisor() {
        System.out.println("deleteSupervisor");
        String id = "";
        SupervisorCollectionsDao instance = new SupervisorCollectionsDao();
        instance.deleteSupervisor(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
