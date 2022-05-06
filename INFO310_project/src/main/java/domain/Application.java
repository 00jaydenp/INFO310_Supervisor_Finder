/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Jayden
 */
public class Application {
    private String applicationID;
    private Student student;
    private Project project;
    
    public String getApplicationID(){
        return applicationID;
    }
    
    public void setApplicationID(String applicationID){
        this.applicationID = applicationID;
    }
    
    public Student getStudent(){
        return student;
    }
    
    public void setStudent(Student student){
        this.student = student;
    }
    
    public Project getProject(){
        return project;
    }
    
    public void setProject(Project project){
        this.project = project;
    }

}
