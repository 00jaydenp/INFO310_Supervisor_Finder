/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import domain.Application;
import io.jooby.Jooby;
import dao.ApplicationDao;
import domain.ErrorMessage;
import domain.Student;
import io.jooby.StatusCode;

/**
 *
 * @author Jayden
 */
public class ApplicationResource extends Jooby {

    public ApplicationResource(ApplicationDao dao) {
        path("api/project/application/{projectID}", () -> {
            get("", ctx -> {
                String id = ctx.path("projectID").value();
                Application application = dao.getApplicationByProjectID(id);
                if (application == null) {
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return application;
                }
            });
        });

        path("api/application/{studentID}", () -> {
            get("", ctx -> {
                String id = ctx.path("studentID").value();
                Application application = dao.getApplicationByStudentID(id);
                if (application == null) {
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return application;
                }
            });
        });

        path("api/application/{studentID}", () -> {
            get("", ctx -> {
                String id = ctx.path("studentID").value();
                Application application = dao.getApplicationByStudentID(id);
                if (application == null) {
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return application;
                }
            });
        });

        path("api/project/application", () -> {
            post("", ctx -> {
                Application application = ctx.body().to(Application.class);
                if (dao.getApplicationByProjectID(application.getProject().getProjectID()) == null) {
                    dao.addApplication(application);
                    return ctx.send(StatusCode.CREATED);
                } else {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("There is already an existing student with this ID in the system"));
                }
            });
        });

    }

}
