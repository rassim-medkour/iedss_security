package com.auth.jwt.iedss.iedss_security.controllers;

import com.auth.jwt.iedss.iedss_security.models.Doctor;
import com.auth.jwt.iedss.iedss_security.repository.CreateDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    CreateDoctorRepository createDoctorRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/nurse")
    @PreAuthorize("hasRole('NURSE')")
    public String userAccess() { return "NURSE Content."; }

    /*@GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }*/

    @GetMapping("/doctor")
    @PreAuthorize("hasRole('DOCTOR')")
    public String adminAccess() {
        return "DOCTOR Board.";
    }

    @PostMapping("/doctor")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor)
    {
        createDoctorRepository.insertWithQuery(doctor);
        return ResponseEntity.ok(doctor);
    }
}