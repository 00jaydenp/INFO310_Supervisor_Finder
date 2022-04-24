/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import dao.JDBIDaoFactory;
import dao.StudentDao;
import dao.SupervisorDAO;
import dao.UserDAO;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import java.io.IOException;
import resource.StudentResource;
import resource.SupervisorResource;
import resource.UserResource;

/**
 *
 * @author David
 */
public class SupervisorFinderService extends Jooby{
    private StudentDao studentDao = JDBIDaoFactory.getStudentDao();
    private SupervisorDAO supervisorDao = JDBIDaoFactory.getSupervisorDao();
    private UserDAO userDao = JDBIDaoFactory.getUserDao();
    
    public SupervisorFinderService(){
        
        setServerOptions(new ServerOptions().setPort(8090));
        
        install(new GsonModule());
        install(new OpenAPIModule());

        assets("/openapi.json", "supervisor-finder.json");
        assets("/openapi.yaml", "supervisor-finder.yaml");
        
        mount(new StudentResource(studentDao));
//        mount(new SupervisorResource(supervisorDao));
        mount(new UserResource(userDao));
        
        
        get("/", ctx -> ctx.sendRedirect("/swagger"));
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("\n\n****** Supervisor Finder ******\n\n");
        new SupervisorFinderService().start();
    }
    
}
