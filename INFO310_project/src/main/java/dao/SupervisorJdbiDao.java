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
    
    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR ORDER BY STAFFID")
    @RegisterBeanMapper(Supervisor.class)
    public Collection<Supervisor> getSupervisors();

    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR WHERE STAFFID = :staffID")
    @RegisterBeanMapper(Supervisor.class)
    public Supervisor getSupervisorById(@Bind("staffID") String staffID);

    @Override
    @SqlUpdate("DELETE FROM SUPERVISOR WHERE STAFFID = :staffID")
    public void deleteSupervisor(@Bind("staffID") String staffID);

    @Override
    @SqlUpdate("INSERT INTO SUPERVISOR (STAFFID, FIRSTNAME, LASTNAME, INTERESTS, DESCRIPTION, PHONENUMBER, EMAIL) VALUES (:staffID, :firstName, :lastName, :interests, :description, :phoneNumber, :user.email)")
    public void saveSupervisor(@BindBean Supervisor supervisor);

    @Override
    @SqlUpdate("UPDATE SUPERVISOR SET FIRSTNAME =:firstName, LASTNAME=:lastName, INTERESTS=:interests, DESCRIPTION=:description, PHONENUMBER=:phoneNumber WHERE STAFFID = :staffID")
    public void updateSupervisor(@Bind("staffID")String staffID, @BindBean Supervisor supervisor);
    
    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR WHERE EMAIL = :email")
    @RegisterBeanMapper(Supervisor.class)
    public Supervisor getSupervisorByEmail(@Bind("email")String email);
    
//    @Override
//    public void hideSupervisor(String staffID);
    
}
