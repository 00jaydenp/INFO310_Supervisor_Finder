/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Student;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author phmci811
 */
public interface StudentJdbiDao extends StudentDao {
    
    /*
    add a new student
     */
    @Override
    @SqlUpdate("INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, INTERESTS, DESCRIPTION, PHONENUMBER, GPA, ADDRESS, EMAIL) VALUES (:studentID, :firstName, :lastName, :interests, :description, :phoneNumber, :gpa, :address, :user.email)")
    public void saveStudent(@BindBean Student student);
    
    //get all of the student profile
    @Override
    @SqlQuery("SELECT * FROM STUDENT ORDER BY STUDENTID")
    @RegisterBeanMapper(Student.class)
    public Collection<Student> getStudents();
    
    /*
    get a specific student profile by student ID
     */
    @Override
    @SqlQuery("SELECT * FROM STUDENT WHERE STUDENTID = :studentID")
    @RegisterBeanMapper(Student.class)
    public Student getStudentByID(@Bind("studentID")String studentID);
    
    /*
    delete a specific student by student ID
     */
    @Override
    @SqlUpdate("DELETE FROM SYSUSER WHERE EMAIL IN (SELECT EMAIL FROM STUDENT WHERE STUDENTID = :studentID)")
    public void deleteStudentByID(@Bind("studentID")String studentID);
    
    /*
    update a specific student by student ID
     */
    @Override 
    @SqlUpdate("UPDATE STUDENT SET FIRSTNAME=:firstName, LASTNAME=:lastName, INTERESTS=:interests, DESCRIPTION=:description, PHONENUMBER=:phoneNumber, GPA=:gpa, ADDRESS=:address, PROJECTID=:projectID WHERE STUDENTID = :studentID")
    public void updateStudentByID(@Bind("studentID")String studentID, @BindBean Student student);
    
    /*
    get a specific student profile by student email
    */
    @Override
    @SqlQuery("SELECT * FROM STUDENT WHERE EMAIL = :email")
    @RegisterBeanMapper(Student.class)
    public Student getStudentByEmail(@Bind("email")String email);
}
