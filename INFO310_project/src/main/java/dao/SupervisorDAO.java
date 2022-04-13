/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Supervisor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author calvi
 */
public interface SupervisorDAO {
    
    /**
     *  Gets the supervisor using staffId
     * @param staffID - id of staff to get
    */
    Supervisor getSupervisorById(String staffID);
    
    /**
     * Adds supervisor
     * @param supervisor - the supervisor to be added 
     */
    void addSupervisor(Supervisor supervisor);
    
    /**
     * Update details of supervisor
     * @param staffID - staff id to update
     * @param supervisor - new details of supervisor
     */
    //void updateSupervisor(String staffID, Supervisor supervisor);
    
    /**
     * Delete a supervisor
     * @param staffID - supervisor to be deleted
     */
    void deleteSupervisor(String staffID);
    
    /**
     * Hide a supervisor
     * @param staffID - id of staff to be hidden
     */
    //void hideSupervisor(String staffID);
}

