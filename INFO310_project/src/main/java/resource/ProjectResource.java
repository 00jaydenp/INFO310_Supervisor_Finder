/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.ProjectDao;
import dao.StudentDao;
import domain.ErrorMessage;
import domain.Project;
import io.jooby.Jooby;
import io.jooby.StatusCode;
import java.util.Collection;

/**
 *
 * @author David
 */
public class ProjectResource extends Jooby{
    
    public ProjectResource(ProjectDao dao){
        
        path("api/projects", () -> {
            get("", ctx -> {
                return dao.getProjects();
            });
        });
        
        path("/api/projects/search/{query}", () -> {
           get("", ctx -> {
              String query = ctx.path("query").value();
              return dao.getProjectsByQuery(query);
           }); 
        });
        
        path("/api/supervisor/projects/{staffID}", () -> {
            get("", ctx -> {
                String id = ctx.path("staffID").value();
                Collection<Project> projects = dao.getProjectsByStaffID(id);
                if(projects.isEmpty()){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return projects;
                }
            });
        });
        
        path("/api/projects/{projectID}", () -> {
            get("", ctx -> {
                String id = ctx.path("projectID").value();
                Project project = dao.getProjectByID(id);
                if(project == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    return project;
                }
            });
            
            put("", ctx -> {
                String id = ctx.path("projectID").value();
                if(dao.getProjectByID(id) == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    Project project = ctx.body().to(Project.class);
                    if(!id.equals(project.getProjectID())){
                        return ctx
                                .setResponseCode(StatusCode.CONFLICT)
                                .render(new ErrorMessage("Modifying the project's ID via this operation is not allowed.  Create a new project instead."));
                    } else {
                        dao.updateProjectByID(id, project);
                        return ctx.send(StatusCode.NO_CONTENT);
                    }
                }
            });
            
            delete("", ctx -> {
                String id = ctx.path("projectID").value();
                if(dao.getProjectByID(id) == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else {
                    dao.deleteProjectByID(id);
                    return ctx.send(StatusCode.NO_CONTENT);
                }
            });
        });
        
        path("/api/supervisor/projects", () -> {
            get("", ctx -> {
                return dao.getProjects();
            });
            
            post("", ctx -> {
                Project project = ctx.body().to(Project.class);
                if (dao.getProjectByID(project.getProjectID()) == null) {
                    dao.saveProject(project);
                    return ctx.send(StatusCode.CREATED);
                } else {
                    return ctx
                            .setResponseCode(StatusCode.CONFLICT)
                            .render(new ErrorMessage("There is already an existing project with this ID in the system"));
                }
            });
        });
    }
    
}
