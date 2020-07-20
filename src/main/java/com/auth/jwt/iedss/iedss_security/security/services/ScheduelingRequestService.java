package com.auth.jwt.iedss.iedss_security.security.services;

import com.auth.jwt.iedss.iedss_security.models.PatientScheduelingForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
aiguilleur
 */
@Service
public class ScheduelingRequestService {
    Logger logger = LoggerFactory.getLogger(ScheduelingRequestService.class);

    public String requestScheduelingDecesionMaker(PatientScheduelingForm patientScheduelingForm){
        String decision = null;
        if (patientScheduelingForm.getSevirityIndex()>4){
            decision = "LOCAL";
        }else{
            decision = "DISTANT";
        }
        logger.info(patientScheduelingForm.getSevirityIndex()+" and decision is : "+decision);
        return decision;
    }
}
