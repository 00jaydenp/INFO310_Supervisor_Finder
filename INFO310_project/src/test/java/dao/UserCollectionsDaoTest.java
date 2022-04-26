/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import domain.User;
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
public class UserCollectionsDaoTest {
    
    private UserDao userDao;
    
    private User user1;
    private User user2;
    private User user3;

    @BeforeAll
    public static void initialise(){
        JDBIDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }

    @BeforeEach
    public void setUp() {
        
        userDao = JDBIDaoFactory.getUserDao();
        
        user1 = new User();
        user1.setEmail("doejo222@otago.ac.nz");
        user1.setPassword("Scienceisfun1");
        
        user2 = new User();
        user2.setEmail("doeja333@otago.ac.nz");
        user2.setPassword("Musicislove2");
        
        user3 = new User();
        user3.setEmail("doeja233@student.otago.ac.nz");
        user3.setPassword("Mynameisjack3");
        
        userDao.saveUser(user1);
        userDao.saveUser(user2);
    }
    
    @AfterEach
    public void tearDown() {
        userDao.deleteUser(user1.getEmail());
        userDao.deleteUser(user2.getEmail());
        userDao.deleteUser(user3.getEmail());
    }

    /**
     * Test of saveUser method, of class UserCollectionsDao.
     */
    @Test
    public void testSaveUser() {
        userDao.saveUser(user3);
        assertThat(userDao.getUsers(), hasSize(3));
        assertThat(userDao.getUsers(), hasItems(user1, user2, user3));
    }

    /**
     * Test of getUser method, of class UserCollectionsDao.
     */
    @Test
    public void testGetUser() {
        User testUser = userDao.getUser(user1.getEmail());
        assertThat(testUser, is(user1));
        assertThat(testUser, not(is(user2)));
    }

    /**
     * Test of deleteUser method, of class UserCollectionsDao.
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(user1.getEmail());
        assertThat(userDao.getUsers(), not(hasItem(user1)));
        assertThat(userDao.getUsers(), hasSize(1));
    }

    /**
     * Test of getUsers method, of class UserCollectionsDao.
     */
    @Test
    public void testGetUsers() {
        assertThat(userDao.getUsers(), hasItems(user1, user2));
        assertThat(userDao.getUsers(), not(hasItem(user3)));
    }
    
}
