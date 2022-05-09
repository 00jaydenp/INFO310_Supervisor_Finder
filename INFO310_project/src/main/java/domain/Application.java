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
    private String studentID;
    private String projectID;
    
    private Student student;
    private Project project;
    
    public String getApplicationID(){
        return applicationID;
    }
    
    public void setApplicationID(String applicationID){
        this.applicationID = applicationID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
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
