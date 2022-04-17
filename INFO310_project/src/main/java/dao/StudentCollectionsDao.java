/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author phmci811
 */
public class StudentCollectionsDao implements StudentDao {
    private static Collection<Student> students = new HashSet<>();
    private static final Map<String, Student> studentIDMap = new HashMap<>();
    
    /*
    add a new student
    */
    @Override
    public void saveStudent(Student student){
        studentIDMap.put(student.getStudentID(), student);
    }
    
    /*
    get all of the student profile 
    */
    @Override
    public Collection<Student> getStudents() {
        return students;
    }
    
    /*
    get a specific student profile by student ID
    */
    @Override
    public Student getByID(String id){
        return studentIDMap.get(id);
    }
    
    /*
    delete a specific student by student ID
    */
    @Override
    public void deleteStudent(String id){
        Student student = studentIDMap.get(id);
        studentIDMap.remove(student.getStudentID());
    }
    
    /*
    update a specific student by student ID
    */
    @Override
    public void updateStudent(Student updatedStudent){
        //studentIDMap.put(id, updatedStudent);
        throw new UnsupportedOperationException("Not supported yet");  
    }
}
