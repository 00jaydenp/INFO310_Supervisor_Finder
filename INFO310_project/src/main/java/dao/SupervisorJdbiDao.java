/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Supervisor;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author calvi
 */
public interface SupervisorJdbiDao extends SupervisorDao {
    //get all of the supervisor profile
    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR ORDER BY STAFFID")
    @RegisterBeanMapper(Supervisor.class)
    public Collection<Supervisor> getSupervisors();

    /*
    get a specific supervisor profile by staff ID
     */
    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR WHERE STAFFID = :staffID")
    @RegisterBeanMapper(Supervisor.class)
    public Supervisor getSupervisorById(@Bind("staffID") String staffID);

    /*
    delete a specific supervisor by staff ID
     */
    @Override
    @SqlUpdate("DELETE FROM SYSUSER WHERE EMAIL IN (SELECT EMAIL FROM SUPERVISOR WHERE STAFFID = :staffID)")
    public void deleteSupervisor(@Bind("staffID") String staffID);

    /*
    add a new supervisor
     */
    @Override
    @SqlUpdate("INSERT INTO SUPERVISOR (STAFFID, FIRSTNAME, LASTNAME, INTERESTS, DESCRIPTION, PHONENUMBER, EMAIL) VALUES (:staffID, :firstName, :lastName, :interests, :description, :phoneNumber, :user.email)")
    public void saveSupervisor(@BindBean Supervisor supervisor);

    /*
    update a specific supervisor by staff ID
     */
    @Override
    @SqlUpdate("UPDATE SUPERVISOR SET FIRSTNAME =:firstName, LASTNAME=:lastName, INTERESTS=:interests, DESCRIPTION=:description, PHONENUMBER=:phoneNumber WHERE STAFFID = :staffID")
    public void updateSupervisor(@Bind("staffID")String staffID, @BindBean Supervisor supervisor);
    
    /*
    get a specific supervisor profile by staff email
    */
    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR WHERE EMAIL = :email")
    @RegisterBeanMapper(Supervisor.class)
    public Supervisor getSupervisorByEmail(@Bind("email")String email);
    
//    @Override
//    public void hideSupervisor(String staffID);
    
}
