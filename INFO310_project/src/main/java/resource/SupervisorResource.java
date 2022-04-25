/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.SupervisorDao;
import domain.ErrorMessage;
import domain.Supervisor;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author calvi
 */
public class SupervisorResource extends Jooby{
    public SupervisorResource(SupervisorDao dao) {
        path("/api/supervisor/profile", () -> {
            get("", ctx -> {
                return dao.getSupervisors();
            });
        });

        path("/api/supervisor/profile/{staffID}", () -> {

            get("", ctx -> {
                String id = ctx.path("staffID").value();
                Supervisor supervisor = dao.getSupervisorById(id);
                if(supervisor == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return supervisor;
                }
            });

            delete("", ctx -> {
                String id = ctx.path("staffID").value();
                if(dao.getSupervisorById(id) == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    dao.deleteSupervisor(id);
                    return ctx.send(StatusCode.NO_CONTENT);
                }
            });

            put("", ctx -> {
                String id = ctx.path("staffID").value();
                if(dao.getSupervisorById(id) == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                }
                else{
                    Supervisor supervisor = ctx.body().to(Supervisor.class);
                    if (!id.equals(supervisor.getStaffID())) {
                        return ctx
                                .setResponseCode(StatusCode.CONFLICT)
                                .render(new ErrorMessage("Modifying the product's ID via this operation is not allowed.  Create a new product instead."));
                    } else {
                        dao.updateSupervisor(id, supervisor);
                        return ctx.send(StatusCode.NO_CONTENT);
                    }
                }
            });
        });  
        
        path("/api/sign-up/supervisor", () -> {
            post("", ctx -> {
                Supervisor supervisor = ctx.body().to(Supervisor.class);
                if (dao.getSupervisorById(supervisor.getStaffID()) == null) {
                    dao.saveSupervisor(supervisor);
                    return ctx.send(StatusCode.CREATED);
                } else {
                  return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("There is already an existing Staff member with this ID in the system"));  
                }
            });
        });
    }
}
