/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.Supervisor;
import domain.User;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Jayden
 */
public class SupervisorCollectionsDaoTest {

    private SupervisorDao supervisorDao;
    private UserDao userDao;

    private User user1;
    private User user2;
    private User user3;

    private Supervisor supervisor1;
    private Supervisor supervisor2;
    private Supervisor supervisor3;

    @BeforeAll
    public static void initialise() {
        JDBIDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }

    @BeforeEach
    public void setUp() {

        supervisorDao = JDBIDaoFactory.getSupervisorDao();
        userDao = JDBIDaoFactory.getUserDao();

        user1 = new User();
        user1.setEmail("doejo222@otago.ac.nz");
        user1.setPassword("Scienceisfun1");

        user2 = new User();
        user2.setEmail("doeja333@otago.ac.nz");
        user2.setPassword("Musicislove2");

        user3 = new User();
        user3.setEmail("smibo444@otago.ac.nz");
        user3.setPassword("Mathiscool3");

        userDao.saveUser(user1);
        userDao.saveUser(user2);
        userDao.saveUser(user3);

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

        supervisor3 = new Supervisor();
        supervisor3.setStaffID("smibo444");
        supervisor3.setFirstName("Bob");
        supervisor3.setLastName("Smith");
        supervisor3.setInterests("The inevitable heat death of the universe");
        supervisor3.setDescription("Senior  lecturer in the Otago physics department");
        supervisor3.setPhoneNumber("0212345678");
        supervisor3.setUser(user3);

        supervisorDao.saveSupervisor(supervisor1);
        supervisorDao.saveSupervisor(supervisor2);
    }

    @AfterEach
    public void tearDown() {
        supervisorDao.deleteSupervisor(supervisor1.getStaffID());
        supervisorDao.deleteSupervisor(supervisor2.getStaffID());
        supervisorDao.deleteSupervisor(supervisor3.getStaffID());

        userDao.deleteUser(user1.getEmail());
        userDao.deleteUser(user2.getEmail());
        userDao.deleteUser(user3.getEmail());
    }

    /**
     * Test method to get all supervisors on record
     */
    @Test
    public void testGetSupervisors() {
        // Make sure it returns the two superviors on the database
        assertThat(supervisorDao.getSupervisors(), hasItems(supervisor1, supervisor2));
        //Make sure it only has those two
        assertThat(supervisorDao.getSupervisors(), hasSize(2));

    }

    /**
     * Test method to get supervisor by their specific ID
     */
    @Test
    public void testGetSupervisorById() {
        //Get the supervisor by their ID
        Supervisor testSupervisor = supervisorDao.getSupervisorById(supervisor1.getStaffID());
        //Make sure the returned supervisor is the one specified by the ID
        assertThat(testSupervisor.getStaffID(), is(supervisor1.getStaffID()));
        //Make sure the returned supervisor is not being mistakingly recognised
        assertThat(testSupervisor.getStaffID(), not(is(supervisor2.getStaffID())));

    }

    /**
     * Test to add supervisor to record
     */
    @Test
    public void testSaveSupervisor() {
        //Add supervisor
        supervisorDao.saveSupervisor(supervisor3);
        //Check that there are now 3 supervisors in database
        assertThat(supervisorDao.getSupervisors(), hasSize(3));
        //Make sure it contains all supervisor objects
        assertThat(supervisorDao.getSupervisors(), hasItems(supervisor1, supervisor2, supervisor3));

        //Make Duplicate supervisor 
        final Supervisor supervisor4 = supervisor3;
        // Try adding supervisor4, make sure it throws exception due to duplicate values
        assertThrows(Exception.class, () -> {
            supervisorDao.saveSupervisor(supervisor4);
        });

    }

    /**
     * Test to update existing record of a supervisor
     */
    @Test
    public void testUpdateSupervisor() {
        //Create a clone of Supervisor1 to update
        Supervisor updatedSup = new Supervisor();
        updatedSup.setStaffID("doejo222");
        updatedSup.setFirstName("John");
        updatedSup.setInterests("Space research and Mechanics");
        updatedSup.setDescription("Senior lecturer in the Otago physics department");
        updatedSup.setPhoneNumber("0275556667");
        updatedSup.setUser(user1);
        //update values
        updatedSup.setLastName("Smith");

        //Make sure its not the old value
        assertThat(supervisor1.getLastName(), not(updatedSup.getLastName()));
        //Call update method
        supervisorDao.updateSupervisor(supervisor1.getStaffID(), updatedSup);

        //Make sure the details have updated, get new supervisor
        Supervisor newSup = supervisorDao.getSupervisorById(supervisor1.getStaffID());
        assertThat(newSup.getLastName(), is(updatedSup.getLastName()));

    }

    /**
     * Test to delete a supervisor from the record
     */
    @Test
    public void testDeleteSupervisor() {
        //Delete supervisor by their ID
        supervisorDao.deleteSupervisor(supervisor1.getStaffID());
        //Make sure the Staff is no longer on record
        assertThat(supervisorDao.getSupervisors(), not(hasItem(supervisor1)));
        //Should only be one Staff on record if succesful
        assertThat(supervisorDao.getSupervisors(), hasSize(1));

    }

}
