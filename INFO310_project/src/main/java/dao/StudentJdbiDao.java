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
    
    @Override
    @SqlUpdate("INSERT INTO STUDENT (STUDENTID, FIRSTNAME, LASTNAME, INTEREST, DESCRIPTION, PHONENUMBER, GPA, ADDRESS, EMAIL) VALUES (:studentID, :firstName, :lastName, :interests, :description, :phoneNumber, :gpa, :address, :user.email)")
    public void saveStudent(@BindBean Student student);
    
    @Override
    @SqlQuery("SELECT * FROM STUDENT ORDER BY STUDENTID")
    @RegisterBeanMapper(Student.class)
    public Collection<Student> getStudents();
    
    @Override
    @SqlQuery("SELECT * FROM STUDENT WHERE STUDENTID = :studentID")
    @RegisterBeanMapper(Student.class)
    public Student getByID(@Bind("studentID")String studentID);
    
    @Override
    @SqlUpdate("DELETE FROM STUDENT WHERE STUDENTID = :studentID")
    public void deleteStudent(@Bind("studentID")String studentID);
    
    @Override 
    @SqlUpdate("UPDATE STUDENT SET FIRSTNAME=:firstName, LASTNAME=:lastName, INTEREST=:interests, DESCRIPTION=:description, PHONENUMBER=:phoneNumber, GPA=:gpa, ADDRESS=:address WHERE STUDENTID = :studentID")
    public void updateStudent(@Bind("studentID")String studentID, @BindBean Student student);
    
    
}
