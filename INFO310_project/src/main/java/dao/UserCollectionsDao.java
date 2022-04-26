/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David
 */
public class UserCollectionsDao implements UserDao {
    
    private static final Map<String, User> users = new HashMap<>();
    
    @Override
    public void saveUser(User user){
        users.put(user.getEmail(), user);
    }
    
    @Override
    public User getUser(String email){
        return users.get(email);
    }
    
    @Override
    public void deleteUser(String email){
        users.remove(email);
    }
    
}
