/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.StudentDao;
import domain.ErrorMessage;
import domain.Student;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author phmci811
 */
public class StudentModule extends Jooby {

    public StudentModule(StudentDao studentDao) {

        get("/api/student/profile", ctx -> studentDao.getStudents());

        get("/api/student/profile/{studentID}", ctx -> {
            String id = ctx.path("studentID").value();
            Student stud = studentDao.getByID(id);
            if (stud == null) {  // no student found for that ID
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return stud;
            }
        });
        
        delete("/api/student/profile/{studentID}", ctx -> {
            String id = ctx.path("studentID").value();
                studentDao.deleteStudent(id);
                return ctx.send(StatusCode.NO_CONTENT);
        });
        
        put("/api/student/profile/{studentID}", ctx -> {
            String id = ctx.path("studentID").value();
                Student student = ctx.body().to(Student.class);
                if (!id.equals(student.getStudentID())) {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("Modifying the product's ID via this operation is not allowed.  Create a new product instead."));
                } else {
                    studentDao.updateStudent(id, student);
                    return ctx.send(StatusCode.NO_CONTENT);
                }
        });
    }

}
