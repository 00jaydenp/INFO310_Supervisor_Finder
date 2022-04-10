/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Supervisor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author calvin
 */
public class SupervisorCollectionsDao implements SupervisorDAO{
    private static final Map<String, Supervisor> supervisorsMap = new HashMap<>();

    /**
     * Add some dummy data for testing if required
     */
    public SupervisorCollectionsDao(){
        
    }
    
    /**
     * Get a supervisor
     * @param staffId - id of staff to get
     * @return supervisor requested
     */
    @Override
    public Supervisor getSupervisorById(String staffId) {
        return supervisorsMap.get(staffId);
    }

    /**
     * Adds a supervisor
     * @param supervisor - supervisor to be added 
     */
    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisorsMap.put(supervisor.getStaffID(), supervisor);
    }
    
    /**
     * Update a supervisor
     * @param staffId - id of supervisor to replace
     * @param supervisor - the supervisor to replace it with
     */
    @Override
    public void updateSupervisor(String staffId, Supervisor supervisor) {
        supervisorsMap.put(staffId, supervisor);
    }

    /**
     * Delete a supervisor
     * @param staffId - id of supervisor to be deleted
     */
    @Override
    public void deleteSupervisor(Supervisor staffId) { //not sure here, missing the multimap?!
        Supervisor supervisor = supervisorsMap.remove(staffId);
        supervisorsMap.remove(supervisor); //not sure if this is right
    }

    /**
     * Hide a supervisor
     * @param staffId - id of supervisor to hide
     */
    @Override
    public void hideSupervisor(String staffId) {
        //not sure for this
    }
    
    
    
}
