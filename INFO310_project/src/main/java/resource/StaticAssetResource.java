/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import io.jooby.Jooby;
import io.jooby.Route;
import java.nio.file.Paths;
import static java.nio.file.Paths.get;

/**
 *
 * @author phmci811
 */
public class StaticAssetResource extends Jooby{
    public StaticAssetResource() {

        // handle favicons (silent 404)
        get("/favicon.ico", Route.FAVICON);

        // serve anything that matches a file in the static folder
        assets("/*", Paths.get("static"));
    }
}
