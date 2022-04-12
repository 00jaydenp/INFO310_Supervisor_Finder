/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import org.h2.jdbc.JdbcConnection;
import domain.Student;
import domain.Supervisor;

/**
 *
 * @author francesca
 */
public class UserDAO implements StudentDao, SupervisorDAO {
    
    private final String studentUri = JDBIDaoFactory.getDefaultConnectionJdbcUri();
    private final String supervisorUri = JDBIDaoFactory.getDefaultConnectionJdbcUri();
  
    public void deleteStudent(String Id){
        String sql = "delete from student where studentID =?";
        try(
            Connection dbCon = JDBIDaoFactory.getConnection(studentUri);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
                ){
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
   
    public void deleteSupervisor(Supervisor supervisor){
        String sql = "delete from supervisor where supervisorID =?";
        try(
            Connection dbCon = JDBIDaoFactory.getConnection(supervisorUri);
            PreparedStatement stmt = dbCon.prepareStatement(sql);
                ){
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
   // public void changePassword(User user){

    @Override
    public Student getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Supervisor getSupervisorById(String staffId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSupervisor(String staffId, Supervisor supervisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hideSupervisor(String staffId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
