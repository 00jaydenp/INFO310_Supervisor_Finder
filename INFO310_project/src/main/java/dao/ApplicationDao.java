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
    
    
    Collection<Application> getApplicationByProjectID(String projectID);
    
    Collection<Application> getApplicationByStudentID(String studentID);
    
    void addApplication(Application application);
    
    void deleteApplication(String studentID);
}
