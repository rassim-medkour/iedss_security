package com.auth.jwt.iedss.iedss_security.controllers;

import com.auth.jwt.iedss.iedss_security.models.Patient;
import com.auth.jwt.iedss.iedss_security.models.PatientScheduelingForm;
import com.auth.jwt.iedss.iedss_security.repository.CreatePatientRepository;
import com.auth.jwt.iedss.iedss_security.repository.PatientRepository;
import com.auth.jwt.iedss.iedss_security.security.services.ScheduelingRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Timestamp;


@RestController
public class SchedulingRequestController {
    Logger logger = LoggerFactory.getLogger(SchedulingRequestController.class);


    ScheduelingRequestService scheduelingRequestService = new ScheduelingRequestService();
    @Autowired
    CreatePatientRepository createPatientRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RestTemplate restTemplate;
    
    String fooResourceUrl = "http://localhost:9001";
    @PostMapping(value = "/auth/sch_req",consumes = "application/json",produces = "text/plain")
    @PreAuthorize("hasRole('NURSE')")
    public void scheduelingReqHandler(@RequestBody PatientScheduelingForm patientScheduelingForm){
        patientScheduelingForm.setEntranceTime((new Timestamp(System.currentTimeMillis())));
        ResponseEntity<String> responseEntity;
        //Sending the Scheduling Request to the Local Emergency Scheduler Or Distant (Cloud)
        if (scheduelingRequestService.requestScheduelingDecesionMaker(patientScheduelingForm)=="LOCAL"){
        	logger.info("********* wtf *******");
                restTemplate.
                postForObject(fooResourceUrl+"/local_scheduel",patientScheduelingForm,PatientScheduelingForm.class);
        }else {
            //restTemplate.postForObject();
        }
    }
}
