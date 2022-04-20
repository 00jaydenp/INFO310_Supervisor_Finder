/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import domain.Student;
import domain.Supervisor;

/**
 *
 * @author francesca
 */
public abstract class  UserDAO implements StudentDao, SupervisorDAO {
    
    
    @Override
    public void deleteStudent(String Id){
        JDBIDaoFactory.getStudentDao().deleteStudent(Id);
        
    }
 
    public void deleteSupervisor(String Id){
        JDBIDaoFactory.getSupervisorDao().deleteSupervisor(Id);
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

    public void updateSupervisor(String staffId, Supervisor supervisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void hideSupervisor(String staffId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
