/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Project;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author David
 */
public class ProjectCollectionsDao {
    
    private static final Collection<Project> projects = new HashSet<>();
    private static final Map<String, Project> projectsIDMap = new HashMap<>();
    
    public void saveProject(Project project){
        projects.add(project);
        projectsIDMap.put(project.getProjectID(), project);
    }

    
    
}
