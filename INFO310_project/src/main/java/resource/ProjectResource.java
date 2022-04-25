/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.ProjectCollectionsDao;
import dao.ProjectDao;
import domain.ErrorMessage;
import domain.Project;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author David
 */
public class ProjectResource extends Jooby{
    
    public ProjectResource(ProjectDao dao){
        path("/api/projects/search/{query}", () -> {
           get("", ctx -> {
              String query = ctx.path("query").value();
              return dao.getProjectsByQuery(query);
           }); 
        });
        
        path("/api/supervisor/projects/{staffID}", () -> {
            get("", ctx -> {
                String id = ctx.path("staffID").value();
                return dao.getProjectsByStaffID(id);
            });
        });
        
        path("/api/projects/{projectID}", () -> {
            get("", ctx -> {
                String id = ctx.path("projectID").value();
                return dao.getProjectByID(id);
            });
            
            put("", ctx -> {
                String id = ctx.path("projectID").value();
                Project project = ctx.body().to(Project.class);
                if(!id.equals(project.getProjectID())){
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("Modifying the project's ID via this operation is not allowed.  Create a new project instead."));
                } else {
                    dao.updateProjectByID(id, project);
                    return ctx.send(StatusCode.NO_CONTENT);
                }
            });
            
            delete("", ctx -> {
                String id = ctx.path("projectID").value();
                dao.deleteProjectByID(id);
                return ctx.send(StatusCode.NO_CONTENT);
            });
        });
        
        path("/api/supervisor/projects", () -> {
            post("", ctx -> {
                Project project = ctx.body().to(Project.class);
                if (ProjectCollectionsDao.exists(project.getProjectID())) {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("There is already an existing project with this ID in the system"));
                } else {
                    dao.saveProject(project);
                    return ctx.send(StatusCode.CREATED);
                }
            });
        });
    }
    
}
