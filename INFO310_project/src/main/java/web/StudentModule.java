/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.StudentDao;
import io.jooby.Jooby;

/**
 *
 * @author phmci811
 */
public class StudentModule extends Jooby{
    public StudentModule(StudentDao dao){
        
        get("/api/student/profile", ctx -> dao.getStudents());
        
        /*get("/api/profile/{studentID}", ctx -> {
            
        });*/
    }
}
