/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import dao.UserDAO;
import domain.User;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author David
 */
public class UserResource extends Jooby {
    
    public UserResource(UserDAO dao){
        path("/api/login/{email}", () -> {
            get("", ctx -> {
                String email = ctx.path("email").value();
                User user = dao.getUser(email);
                if (user == null){
                    return ctx.send(StatusCode.NOT_FOUND);
                } else{
                    return user;
                }
            });
        });
        
        path("/api/sign-up", () -> {
            post("", ctx -> {
                User user = ctx.body().to(User.class);
                dao.saveUser(user);
                return ctx.send(StatusCode.CREATED);
            });
        });
    }
    
}
