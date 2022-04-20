/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.JDBIDaoFactory;
import dao.StudentDao;
import io.jooby.Jooby;
import io.jooby.ServerOptions;

/**
 *
 * @author phmci811
 */
public class Server extends Jooby {
    
    private StudentDao studentDao = JDBIDaoFactory.getStudentDao();

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        new Server().start();
    }

    public Server() {
        setServerOptions(new ServerOptions().setPort(8090));

        get("/", ctx -> "Hello World");
    }

}
