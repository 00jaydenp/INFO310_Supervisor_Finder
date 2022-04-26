/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.User;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author David
 */
public interface UserJdbiDao extends UserDao{
    
    @Override
    @SqlUpdate("INSERT INTO SYSUSER (EMAIL, PASSWORD) VALUES (:email, :password)")
    public void saveUser(@BindBean User user);
    
    @Override
    @SqlQuery("SELECT * FROM SYSUSER WHERE EMAIL = :email")
    @RegisterBeanMapper(User.class)
    public User getUser(@Bind("email")String email);
    
    @Override
    @SqlUpdate("DELETE FROM SYSUSER WHERE EMAIL = :email")
    public void deleteUser(@Bind("email")String email);
    
    @Override
    @SqlQuery("SELECT * FROM SYSUSER ORDER BY EMAIL")
    @RegisterBeanMapper(User.class)
    public Collection<User> getUsers();
    
}
