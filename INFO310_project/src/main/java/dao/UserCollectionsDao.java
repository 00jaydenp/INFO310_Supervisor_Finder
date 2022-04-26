/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author David
 */
public class UserCollectionsDao implements UserDao {
    private final Collection<User> users = new HashSet<>();
    private static final Map<String, User> usersEmail = new HashMap<>();
    
    @Override
    public void saveUser(User user){
        users.add(user);
        usersEmail.put(user.getEmail(), user);
    }
    
    @Override
    public User getUser(String email){
        return usersEmail.get(email);
    }
    
    @Override
    public void deleteUser(String email){
        users.remove(getUser(email));
        usersEmail.remove(email);
    }
    
    @Override
    public Collection<User> getUsers(){
        return users;
    }
}
