/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Student;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author phmci811
 */
public interface StudentJdbiDao extends StudentDao {
    
    @Override
    @SqlUpdate("INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, INTEREST, DESCRIPTION, PHONENUMBER, GPA, ADDRESS) VALUES (:studentID, :firstName, :lastName, :interests, :description, :phoneNumber, :gpa, :address)")
    public void saveStudent(@BindBean Student student);
    
    @Override
    @SqlQuery("SELECT * FROM STUDENT WHERE STUDENTID = :studentID")
    public Student getByID(@Bind("studentID")String studentID);
    
    @Override
    @SqlUpdate("DELETE FROM STUDENT WHERE STUDENTID = :studentID")
    public void deleteStudent(@Bind("studentID")String studentID);
    
    //@Override 
    //@SqlUpdate("Update Student set FIRSTNAME=:firstName, LASTNAME=:lastName, INTEREST=:interests, DESCRIPTION=:description, PHONENUMBER=:phoneNumber, GPA=:gpa, ADDRESS=:address")
    //public void updateStudent(@Bind("studentID")String studentID);
    
}
