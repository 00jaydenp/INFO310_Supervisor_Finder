/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
/**
 *
 * @author francesca
 */
public interface UserDAO {
    void deleteUser(User user);
    void changePassword(User user);
    
}
