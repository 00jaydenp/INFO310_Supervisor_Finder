/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Project;
import domain.Supervisor;
import domain.User;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David
 */
public class ProjectCollectionsDaoTest {
    
    private ProjectDao projectDao;
    private SupervisorDao supervisorDao;
    private UserDao userDao;
    
    private User user1;
    private User user2;
    
    private Supervisor supervisor1;
    private Supervisor supervisor2;
    
    private Project project1;
    private Project project2;
    private Project project3;
    
    @BeforeAll
    public static void initialise(){
        JDBIDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }
    
    @BeforeEach
    public void setUp() {
        projectDao = JDBIDaoFactory.getProjectDao();
        supervisorDao = JDBIDaoFactory.getSupervisorDao();
        userDao = JDBIDaoFactory.getUserDao();
        
        user1 = new User();
        user1.setEmail("doejo222@otago.ac.nz");
        user1.setPassword("Scienceisfun1");
        
        user2 = new User();
        user2.setEmail("doeja333@otago.ac.nz");
        user2.setPassword("Musicislove2");
        
        userDao.saveUser(user1);
        userDao.saveUser(user2);
        
        supervisor1 = new Supervisor();
        supervisor1.setStaffID("doejo222");
        supervisor1.setFirstName("John");
        supervisor1.setLastName("Doe");
        supervisor1.setInterests("Space research and Mechanics");
        supervisor1.setDescription("Senior lecturer in the Otago physics department");
        supervisor1.setPhoneNumber("0275556667");
        supervisor1.setUser(user1);
        
        supervisor2 = new Supervisor();
        supervisor2.setStaffID("doeja333");
        supervisor2.setFirstName("Jane");
        supervisor2.setLastName("Doe");
        supervisor2.setInterests("Music and its influence on culture");
        supervisor2.setDescription("First year lecturer in the Otago music department");
        supervisor2.setPhoneNumber("0221112223");
        supervisor2.setUser(user2);
        
        supervisorDao.saveSupervisor(supervisor1);
        supervisorDao.saveSupervisor(supervisor2);
        
        project1 = new Project();
        project1.setProjectID("phy11");
        project1.setName("Physics Reasearch");
        project1.setDescription("Reasearching mechanics in micro-gravity");
        project1.setStatus("Completed");
        project1.setDate("15/5/2021");
        project1.setSupervisor(supervisor1);
        
        project2 = new Project();
        project2.setProjectID("phy22");
        project2.setName("Projectiles in space");
        project2.setDescription("We are wanting to see what object shapes travel best through a vaccume");
        project2.setStatus("New Project");
        project2.setDate("20/4/2022");
        project2.setSupervisor(supervisor1);
        
        project3 = new Project();
        project3.setProjectID("mus01");
        project3.setName("Reasearching Music in ancient culture");
        project3.setDescription("We are wanting to see how music shaped its way though ancient civilisations");
        project3.setStatus("On-going Project");
        project3.setDate("31/12/2021");
        project3.setSupervisor(supervisor2);
        
        projectDao.saveProject(project1);
        projectDao.saveProject(project2);
    }
    
    
    @AfterEach
    public void tearDown() {
        projectDao.deleteProjectByID(project1.getProjectID());
        projectDao.deleteProjectByID(project2.getProjectID());
        projectDao.deleteProjectByID(project3.getProjectID());
        
        supervisorDao.deleteSupervisor(supervisor1.getStaffID());
        supervisorDao.deleteSupervisor(supervisor2.getStaffID());
        
        userDao.deleteUser(user1.getEmail());
        userDao.deleteUser(user2.getEmail());
    }

    /**
     * Test of saveProject method, of class ProjectCollectionsDao.
     */
    @Test
    public void testSaveProject() {
        projectDao.saveProject(project3);
        assertThat(projectDao.getProjects(), hasSize(3));
        assertThat(projectDao.getProjects(), hasItems(project1, project2, project3));
    }

    /**
     * Test of getProjectsByStaffID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjectsByStaffID() {
        projectDao.saveProject(project3);
        Collection<Project> testProjects = projectDao.getProjectsByStaffID(project1.getSupervisor().getStaffID());
        assertThat(testProjects, hasItems(project1, project2));
        assertThat(testProjects, not(hasItem(project3)));
    }

    /**
     * Test of getProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjectByID() {
        Project testProject = projectDao.getProjectByID(project1.getProjectID());
        assertThat(testProject, is(project1));
        assertThat(testProject, not(is(project2)));
    }

    /**
     * Test of updateProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testUpdateProjectByID() {
        Project testProject = new Project();
        testProject.setProjectID(project1.getProjectID());
        testProject.setName(project1.getName());
        testProject.setDescription(project1.getDescription());
        testProject.setStatus("On-Going project");
        testProject.setDate(project1.getDate());
        testProject.setSupervisor(project1.getSupervisor());
        
        projectDao.updateProjectByID(project1.getProjectID(), testProject);
        assertThat(project1, is(testProject));
    }

    /**
     * Test of deleteProjectByID method, of class ProjectCollectionsDao.
     */
    @Test
    public void testDeleteProjectByID() {
        projectDao.deleteProjectByID(project1.getProjectID());
        assertThat(projectDao.getProjects(), not(hasItem(project1)));
        assertThat(projectDao.getProjects(), hasSize(1));
    }

    /**
     * Test of getProjectsByQuery method, of class ProjectCollectionsDao.
     */
    /*@Test
    public void testGetProjectsByQuery() {

    }*/

    /**
     * Test of getProjects method, of class ProjectCollectionsDao.
     */
    @Test
    public void testGetProjects() {
        assertThat(projectDao.getProjects(), hasItems(project1, project2));
        assertThat(projectDao.getProjects(), not(hasItem(project3)));
    }
    
}
