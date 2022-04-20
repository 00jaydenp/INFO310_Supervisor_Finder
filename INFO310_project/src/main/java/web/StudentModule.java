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
    public StudentModule(StudentDao studentDao){
        
        get("/api/student/profile", ctx -> studentDao.getStudents());
        
        /*get("/api/profile/{studentID}", ctx -> {
            
        });*/
    }
}
