/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import domain.Application;
import java.util.Collection;

/**
 *
 * @author Jayden
 */
public interface ApplicationDao {
    
    
    Application getApplicationByProjectID(String id);
    
    Application getApplicationByStudentID(String id);
    
    void addApplication(Application application);
}
