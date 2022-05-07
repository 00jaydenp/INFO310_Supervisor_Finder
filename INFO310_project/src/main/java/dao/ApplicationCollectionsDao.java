/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import domain.Application;
import domain.Student;
import domain.Supervisor;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.misc.MultiMap;

/**
 *
 * @author Jayden
 */
public class ApplicationCollectionsDao implements ApplicationDao {

    private static final Map<String, Application> applications = new TreeMap<>();
    private static final Multimap<String, Application> applicationStudentIDMap = ArrayListMultimap.create();
    private static final Multimap<String, Application> applicationProjectIDMap = ArrayListMultimap.create();

    @Override
    public Collection<Application> getApplicationByProjectID(String projectID) {
      return applicationProjectIDMap.get(projectID);
    }

    @Override
    public Collection<Application> getApplicationByStudentID(String studentID) {
        return applicationStudentIDMap.get(studentID);
    }

    @Override
    public void addApplication(Application application) {
        applications.put(application.getApplicationID(), application);
    }

}
