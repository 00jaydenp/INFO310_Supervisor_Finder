/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;
 
import io.jooby.Jooby;
import java.nio.file.Paths;
 
/**
 *
 * @author phmci811
 */
public class StaticAssetResource extends Jooby{
    public StaticAssetResource() {

 
        // serve anything that matches a file in the static folder
        assets("/*", Paths.get("static"));
    }
}