package com.auth.jwt.iedss.iedss_security.repository;

import com.auth.jwt.iedss.iedss_security.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query(value = "SELECT * FROM patients where name = 1?",nativeQuery = true)
    Optional<Patient> findByName(String name);

    Patient findPatientByName(String name);

}
