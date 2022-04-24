/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.StudentCollectionsDao;
import dao.StudentDao;
import domain.Student;
import domain.ErrorMessage;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author phmci811
 */
public class StudentResource extends Jooby {

    public StudentResource(StudentDao dao) {
        path("/api/student/profile", () -> {
            get("", ctx -> {
                return dao.getStudents();
            });
        });

        path("/api/profile/{studentID}", () -> {

            get("", ctx -> {
                String id = ctx.path("studentID").value();
                return dao.getStudentByID(id);
            });

            delete("", ctx -> {
                String id = ctx.path("studentID").value();
                dao.deleteStudentByID(id);
                return ctx.send(StatusCode.NO_CONTENT);
            });

            put("", ctx -> {
                String id = ctx.path("studentID").value();
                Student student = ctx.body().to(Student.class);
                if (!id.equals(student.getStudentID())) {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("Modifying the product's ID via this operation is not allowed.  Create a new product instead."));
                } else {
                    dao.updateStudentByID(id, student);
                    return ctx.send(StatusCode.NO_CONTENT);
                }
            });
        });  
        
        path("/api/sign-up/student", () -> {
            post("", ctx -> {
                Student student = ctx.body().to(Student.class);
                if (StudentCollectionsDao.exists(student.getStudentID())) {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("There is already an existing student with this ID in the system"));
                } else {
                    dao.saveStudent(student);
                    return ctx.send(StatusCode.CREATED);
                }
            });
        });
    }
}
