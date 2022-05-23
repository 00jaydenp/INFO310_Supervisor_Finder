/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Supervisor;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author calvin
 */
public class SupervisorCollectionsDao implements SupervisorDao {
    private static final Collection<Supervisor> supervisors = new HashSet<>();
    private static final Map<String, Supervisor> supervisorsIDMap = new HashMap<>();
    private static final Map<String, Supervisor> supervisorsEmailMap = new HashMap<>();

    /**
     * Get all the supervisors
     * 
     * @return a collection of supervisors
     */
    @Override
    public Collection<Supervisor> getSupervisors() {
        return supervisors;
    }
    
    /**
     * Get a supervisor by their id
     *
     * @param id - id of staff to get
     * @return supervisor requested
     */
    @Override
    public Supervisor getSupervisorById(String id) {
        return supervisorsIDMap.get(id);
    }

    /**
     * Adds a supervisor to the data structures
     *
     * @param supervisor - supervisor to be added
     */
    @Override
    public void saveSupervisor(Supervisor supervisor) {
        supervisors.add(supervisor);
        supervisorsIDMap.put(supervisor.getStaffID(), supervisor);
        supervisorsEmailMap.put(supervisor.getUser().getEmail(), supervisor);
    }

    /**
     * Update a supervisor by their ID
     *
     * @param id - id of supervisor to replace
     * @param supervisor - the supervisor to replace it with
     */
    @Override
    public void updateSupervisor(String id, Supervisor supervisor) {
        supervisorsIDMap.put(id, supervisor);
    }


    /**
     * Hide a supervisor
     *
     * @param staffID - id of supervisor to hide
     */
    //@Override
    //public void hideSupervisor(String staffID) {
        //not sure for this
    //}
    
    /**
     * Delete a supervisor
     *
     * @param id - id of supervisor to be deleted
     */
    @Override
    public void deleteSupervisor(String id) {
        Supervisor supervisor = supervisorsIDMap.get(id);
        supervisors.remove(supervisor);
        supervisorsIDMap.remove(id);
    }
    
    /*
    get a specific supervisor profile by staff email
    */
    @Override
    public Supervisor getSupervisorByEmail(String email){
        return supervisorsEmailMap.get(email);
    }


}
