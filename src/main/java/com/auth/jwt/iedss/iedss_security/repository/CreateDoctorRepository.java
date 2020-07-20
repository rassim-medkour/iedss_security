package com.auth.jwt.iedss.iedss_security.repository;

import com.auth.jwt.iedss.iedss_security.models.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository
public class CreateDoctorRepository{

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
    public void insertWithQuery(Doctor doctor) {
        entityManager.createNativeQuery("INSERT INTO doctors (id, seniority, speciality, user_id) VALUES (?,?,?,?)")
                .setParameter(1, doctor.getId())
                .setParameter(2, doctor.getSeniority())
                .setParameter(3, doctor.getSpeciality())
                .setParameter(4,doctor.getUser_id())
                .executeUpdate();


        try { //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO doctors (id, seniority, speciality, user_id) " +
                    "VALUES ("+doctor.getId()+","+doctor.getSeniority()+","+doctor.getSpeciality()+","+doctor.getUser_id()+")";
            Statement stm = conn.prepareStatement(sql);
            int rs = stm.executeUpdate(sql);
            stm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
