/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.User;
import java.util.Collection;

/**
 *
 * @author David
 */
public interface UserDao {

    User getUser(String email);

    void saveUser(User user);

    void deleteUser(String email);
    
    Collection<User> getUsers();
}
