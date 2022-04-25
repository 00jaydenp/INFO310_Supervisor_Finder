/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import io.jooby.Jooby;
import io.jooby.ServerOptions;


/**
 *
 * @author calvi
 */
public class Server extends Jooby {

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        new Server().start();

    }
    
    public Server(){
        setServerOptions(new ServerOptions().setPort(8080));
        // The mount method will add all of the routes that were 
        //declared in the ProductModule to the service.
    }
    
   
}
