/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Application;
import domain.Project;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author Jayden
 */
public interface ApplicationJdbiDao extends ApplicationDao {
    
    @Override
    @SqlQuery("SELECT * FROM APPLICATION WHERE PROJECTID = :projectID")
    @RegisterBeanMapper(Application.class)
    public Collection<Application> getApplicationByProjectID(@Bind("projectID")String id);
    
    @Override
    @SqlQuery("SELECT * FROM APPLICATION WHERE STUDENTID = :studentID")
    @RegisterBeanMapper(Application.class)
    public Collection<Application> getApplicationByStudentID(@Bind("studentID")String id);
    
    
    @Override
    @SqlUpdate("INSERT INTO APPLICATION (APPLICATIONID, STUDENTID, PROJECTID) VALUES (:applicationID, :student.studentID, :supervisor.staffID)")
    public void addApplication(@BindBean Application application);
}
