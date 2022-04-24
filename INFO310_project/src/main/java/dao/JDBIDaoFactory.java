/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 *
 * @author phmci
 */
public class JDBIDaoFactory {

    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "sa";

    private static String jdbcUri = "jdbc:h2:tcp://localhost/~/test"; //jdbc:h2:tcp://localhost/~/test

    private static HikariDataSource HIKARI_DATA_SOURCE;
    private static Jdbi JDBI;

    public static void setJdbcUri(String uri) {
        if (HIKARI_DATA_SOURCE != null) {
            throw new IllegalStateException("Connection pool as already been initialised.  It is too late to change the JDBC URI.");
        }

        jdbcUri = uri;
    }

    private static void initialisePool() {
        HIKARI_DATA_SOURCE = new HikariDataSource();
        HIKARI_DATA_SOURCE.setJdbcUrl(jdbcUri);
        HIKARI_DATA_SOURCE.setUsername(DB_USERNAME);
        HIKARI_DATA_SOURCE.setPassword(DB_PASSWORD);

        JDBI = Jdbi.create(HIKARI_DATA_SOURCE);
        JDBI.installPlugin(new SqlObjectPlugin());
    }
    
    public static StudentDao getStudentDao(){
        if (HIKARI_DATA_SOURCE == null) {
            initialisePool();
        }
        return JDBI.onDemand(StudentJdbiDao.class);
    }
    
    public static SupervisorDAO getSupervisorDao(){
        if (HIKARI_DATA_SOURCE == null) {
            initialisePool();
        }
        return JDBI.onDemand(SupervisorJdbiDao.class);
    }
    
    public static UserDAO getUserDao(){
        if (HIKARI_DATA_SOURCE == null) {
            initialisePool();
        }
        return JDBI.onDemand(UserJdbiDao.class);
    }
}
