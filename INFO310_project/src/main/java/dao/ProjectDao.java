/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Project;
import java.util.Collection;

/**
 *
 * @author David
 */
public interface ProjectDao {

    void deleteProjectByID(String id);

    Project getProjectByID(String id);
    
    void updateProjectByID(String id, Project project);

    Collection<Project> getProjectsByQuery(String query);

    Collection<Project> getProjectsByStaffID(String id);

    void saveProject(Project project);
    
}
