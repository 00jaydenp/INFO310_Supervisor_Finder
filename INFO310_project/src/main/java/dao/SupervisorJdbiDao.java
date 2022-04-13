/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Supervisor;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

/**
 *
 * @author calvi
 */
public interface SupervisorJdbiDao extends SupervisorDAO {

    @Override
    @SqlQuery("SELECT * FROM SUPERVISOR WHERE STAFFID = :staffID")
    @RegisterBeanMapper(Supervisor.class)
    public Supervisor getSupervisorById(@Bind("staffID") String staffID);

    @Override
    @SqlQuery("DELETE FROM SUPERVISOR WHERE STAFFID = :staffID")
    public void deleteSupervisor(@Bind("staffID") String staffID);

    @Override
    @SqlQuery("INSERT INTO SUPERVISOR (STAFFID, FIRSTNAME, LASTNAME, INTEREST, DESCRIPTION, PHONENUMBER, EMAIL) VALUES (:staffID, :firstName, :lastName, :interest, :description, :phoneNumber, :email")
    public void addSupervisor(@BindBean Supervisor supervisor);

//    @Override
//    public void updateSupervisor(String staffID, Supervisor supervisor);

//    @Override
//    public void hideSupervisor(String staffID);
    
}
