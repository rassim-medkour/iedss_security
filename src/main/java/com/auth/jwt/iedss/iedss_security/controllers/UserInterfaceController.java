package com.auth.jwt.iedss.iedss_security.controllers;

import com.auth.jwt.iedss.iedss_security.models.Doctor;
import com.auth.jwt.iedss.iedss_security.models.Patient;
import com.auth.jwt.iedss.iedss_security.payload.response.PatientDoctorPosition;
import com.auth.jwt.iedss.iedss_security.repository.PatientRepository;
import com.auth.jwt.iedss.iedss_security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class UserInterfaceController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;

    Logger logger = LoggerFactory.getLogger(UserInterfaceController.class);
    String fooResourceUrl = "http://localhost:9002";

    @PostMapping(value = "/auth/waitinglist")
    @PreAuthorize("hasRole('DOCTOR')")
    public List getDoctorWaitingList(@RequestHeader(name="Authorization") String token){
        String[] split_string = token.split("\\.");
        //String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        //String base64EncodedSignature = split_string[2];
        java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();

        String body = new String(decoder.decode(base64EncodedBody));
        String[] split_body= body.split(",");
        String sub = split_body[0];
        String name = sub.replace("{\"sub\":\"","");
        name = name.replace("\"","");
        userRepository.findByUsername(name);
        List doctors_list = restTemplate.postForObject(fooResourceUrl+"/waitinglist",name, List.class);
        return doctors_list;
    }

    @GetMapping("/affectation/{patient}")
    @PreAuthorize("hasRole('NURSE')")
    public ResponseEntity<PatientDoctorPosition> getTest(@PathVariable("patient") String patientName){
        Patient patient = patientRepository.findPatientByName(patientName);
        return restTemplate.getForEntity(fooResourceUrl + "/patientposition/"+patient.getId(), PatientDoctorPosition.class);

        /*String result =  microserviceLocalEmergencyScheduler.getThis();*/
    }

}
