/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import domain.Project;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author David
 */
public class ProjectCollectionsDao implements ProjectDao {
    
    private static final Map<String, Project> projectsIDMap = new HashMap<>();
    private static final Multimap<String, Project> projectsStaffIDMap = ArrayListMultimap.create();
    private static final Map<String, Project> projectDescriptionMap = new HashMap<>();
    
    @Override
    public void saveProject(Project project){
        projectsStaffIDMap.put(project.getSupervisor().getStaffID(), project);
        projectsIDMap.put(project.getProjectID(), project);
        projectDescriptionMap.put(project.getDescription(), project);
    }

    @Override
    public Collection<Project> getProjectsByStaffID(String id){
        return projectsStaffIDMap.get(id);
    }
    
    @Override
    public Project getProjectByID(String id){
        return projectsIDMap.get(id);
    }
    
    @Override
    public void updateProjectByID(String id, Project project){
        projectsIDMap.put(id, project);
    }
    
    @Override
    public void deleteProjectByID(String id){
        projectsIDMap.remove(id);
    }
    
    @Override
    public Collection<Project> getProjectsByQuery(String query){
        Collection<Project> result = new HashSet<>();
        for(String key : projectDescriptionMap.keySet()){
            if(key.contains(query)){
                result.add(projectDescriptionMap.get(key));
            }
        }
        return result;
    }
    
    public static boolean exists(String id) {
	return projectsIDMap.containsKey(id);
    }
    
}
