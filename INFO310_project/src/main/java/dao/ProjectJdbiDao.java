/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Project;
import java.time.LocalDate;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author David
 */
public interface ProjectJdbiDao extends ProjectDao{
    
    @Override
    @SqlQuery("SELECT * FROM PROJECT ORDER BY PROJECTID")
    @RegisterBeanMapper(Project.class)
    public Collection<Project> getProjects();
    
    @Override
    @SqlUpdate("DELETE FROM PROJECT WHERE PROJECTID = :projectID")
    public void deleteProjectByID(@Bind("projectID")String projectID);

    @Override
    @SqlQuery("SELECT * FROM PROJECT WHERE PROJECTID = :projectID")
    @RegisterBeanMapper(Project.class)
    public Project getProjectByID(@Bind("projectID")String projectID);
    
    @Override
    @SqlUpdate("UPDATE PROJECT SET NAME = :name, DESCRIPTION = :description, STATUS = :status, HIDDEN = :hidden WHERE PROJECTID = :projectID")
    public void updateProjectByID(@Bind("projectID")String projectID, @BindBean Project project);

    @Override
    @SqlQuery("SELECT * FROM PROJECT WHERE DESCRIPTION LIKE CONCAT('%', :query, '%')")
    @RegisterBeanMapper(Project.class)
    public Collection<Project> getProjectsByQuery(@Bind("query")String query);

    @Override
    @SqlQuery("SELECT * FROM PROJECT WHERE STAFFID = :staffID")
    @RegisterBeanMapper(Project.class)
    public Collection<Project> getProjectsByStaffID(@Bind("staffID")String staffID);

    @Override
    @SqlUpdate("INSERT INTO PROJECT (PROJECTID, NAME, DESCRIPTION, STATUS, DATE, STAFFID) VALUES (:projectID, :name, :description, :status, :date, :supervisor.staffID)")
    public void saveProject(@BindBean Project project);
    
}
