/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Project;
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
public class ProjectCollectionsDaoTest {
    
    public ProjectCollectionsDaoTest() {
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
     * Test of saveProject method, of class ProjectCollectionsDao.
     */
    @Test
    public void testSaveProject() {
        System.out.println("saveProject");
        Project project = null;
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        instance.saveProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectsByStaffID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjectsByStaffID() {
        System.out.println("getProjectsByStaffID");
        String id = "";
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        Collection<Project> expResult = null;
        Collection<Project> result = instance.getProjectsByStaffID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjectByID() {
        System.out.println("getProjectByID");
        String id = "";
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        Project expResult = null;
        Project result = instance.getProjectByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testUpdateProjectByID() {
        System.out.println("updateProjectByID");
        String id = "";
        Project project = null;
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        instance.updateProjectByID(id, project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testDeleteProjectByID() {
        System.out.println("deleteProjectByID");
        String id = "";
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        instance.deleteProjectByID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjectsByQuery method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjectsByQuery() {
        System.out.println("getProjectsByQuery");
        String query = "";
        ProjectCollectionsDao instance = new ProjectCollectionsDao();
        Collection<Project> expResult = null;
        Collection<Project> result = instance.getProjectsByQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
