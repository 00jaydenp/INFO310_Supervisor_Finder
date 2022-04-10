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
     * @param staffId - id of staff to get
    */
    Supervisor getSupervisorById(String staffId);
    
    /**
     * Adds supervisor
     * @param supervisor - the supervisor to be added 
     */
    void addSupervisor(Supervisor supervisor);
    
    /**
     * Update details of supervisor
     * @param staffId - staff id to update
     * @param supervisor - new details of supervisor
     */
    void updateSupervisor(String staffId, Supervisor supervisor);
    
    /**
     * Delete a supervisor
     * @param supervisor - supervisor to be deleted
     */
    void deleteSupervisor(Supervisor supervisor);
    
    /**
     * Hide a supervisor
     * @param staffId - id of staff to be hidden
     */
    void hideSupervisor(String staffId);
}

