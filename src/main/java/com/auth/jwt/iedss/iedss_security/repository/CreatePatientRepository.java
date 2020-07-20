package com.auth.jwt.iedss.iedss_security.repository;

import com.auth.jwt.iedss.iedss_security.models.Doctor;
import com.auth.jwt.iedss.iedss_security.models.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class CreatePatientRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://iedss-cloud.cuovdwvtbrk4.us-east-1.rds.amazonaws.com:3306/iedss_cloud";
    // Database credentials
    static final String USER = "admin";
    static final String PASS = "admin1234";
    Connection conn = null;

    @Transactional
    public void insertWithQuery(Patient patient) {
        entityManager.createNativeQuery("INSERT INTO patients (id, injurity, name, sevirity) VALUES (?,?,?,?)")
                .setParameter(1, patient.getId())
                .setParameter(2, patient.getInjurity())
                .setParameter(3, patient.getName())
                .setParameter(4,patient.getSevirity())
                .executeUpdate();

        try { //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO patients (id, injurity, name, sevirity) " +
                    "VALUES ("+patient.getId()+","+patient.getInjurity()+",'"+patient.getName()+"',"+patient.getSevirity()+")";
            Statement stm = conn.prepareStatement(sql);
            int rs = stm.executeUpdate(sql);
            stm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
