/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import io.jooby.Jooby;
import io.jooby.Route;
import java.nio.file.Paths;

/**
 *
 * @author phmci811
 */
public class StaticAssetModule extends Jooby{
    public StaticAssetModule() {

        // handle favicons (silent 404)
        get("/favicon.ico", Route.FAVICON);

        // serve anything that matches a file in the static folder
        assets("/*", Paths.get("static"));
    }
}
