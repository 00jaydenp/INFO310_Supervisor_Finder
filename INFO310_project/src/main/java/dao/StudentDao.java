/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Student;
import java.util.Collection;

/**
 *
 * @author phmci811
 */
public interface StudentDao {
    
    //get all of the student profile 
    Collection<Student> getStudents();

    /*
    delete a specific student by student ID
     */
    void deleteStudent(String id);

    /*
    get a specific student profile by student ID
     */
    Student getByID(String id);

    /*
    add a new student
     */
    void saveStudent(Student student);

    /*
    update a specific student by student ID
     */
    void updateStudent(Student updatedStudent);
    
}
