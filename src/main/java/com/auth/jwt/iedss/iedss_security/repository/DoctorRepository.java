package com.auth.jwt.iedss.iedss_security.repository;

import com.auth.jwt.iedss.iedss_security.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findDoctorById(int id);
    List<Doctor> findAllBySpeciality(int speciality);
}
