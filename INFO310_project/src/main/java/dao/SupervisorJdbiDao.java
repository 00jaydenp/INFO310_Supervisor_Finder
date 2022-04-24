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
    public void deleteSupervisorByID(@Bind("staffID") String staffID);

    @Override
    @SqlUpdate("INSERT INTO SUPERVISOR (STAFFID, FIRSTNAME, LASTNAME, INTEREST, DESCRIPTION, PHONENUMBER, EMAIL) VALUES (:staffID, :firstName, :lastName, :interests, :description, :phoneNumber, :user.email)")
    public void saveSupervisor(@BindBean Supervisor supervisor);

    @Override
    @SqlUpdate("UPDATE SUPERVISOR SET FIRSTNAME =:firstName, LASTNAME=:lastName, INTEREST=:interest, DESCRIPTION=:description, PHONENUMBER=:phoneNumber, EMAIL=:email WHERE STAFFID =: staffID")
    public void updateSupervisorByID(@Bind("staffID")String staffID, @BindBean Supervisor supervisor);
    

//    @Override
//    public void hideSupervisor(String staffID);
    
}
