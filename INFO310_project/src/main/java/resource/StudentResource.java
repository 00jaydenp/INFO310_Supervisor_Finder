/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.StudentDao;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author phmci811
 */
public class StudentResource extends Jooby {
    public StudentResource(StudentDao dao){
        path("/api/student/profile", () -> {
            get("", ctx -> {
                return dao.getStudents();
            });
        });
        
        path("/api/profile/{studentID}", () ->{
            
            get("", ctx -> {
                String id = ctx.path("studentID").value();
                return dao.getByID(id);
            });
            
            delete("", ctx -> {
                String id = ctx.path("studentID").value();
                dao.deleteStudent(id);
                return ctx.send(StatusCode.NO_CONTENT);
            });
        });
    }
}
