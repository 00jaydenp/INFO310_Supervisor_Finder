/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Student;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phmci811
 */
public class StudentCollectionsDao {
    private static final Map<String, Student> studentIDMap = new HashMap<>();
    
    /*
    add a new student
    */
    public void saveStudent(Student student){
        studentIDMap.put(student.getStudentID(), student);
    }
    
    /*
    get a specific student profile by student ID
    */
    public Student getByID(String id){
        return studentIDMap.get(id);
    }
    
    /*
    delete a specific student by student ID
    */
    public void deleteStudent(String id){
        Student student = studentIDMap.get(id);
        studentIDMap.remove(student.getStudentID());
    }
    
    /*
    update a specific student by student ID
    */
    public void updateStudent(String id, Student updatedStudent){
        studentIDMap.put(id, updatedStudent);
        
    }
}
