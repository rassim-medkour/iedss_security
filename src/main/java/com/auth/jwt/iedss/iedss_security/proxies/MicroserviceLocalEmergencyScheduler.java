package com.auth.jwt.iedss.iedss_security.proxies;

import com.auth.jwt.iedss.iedss_security.models.PatientScheduelingForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-local-emergency-scheduler", url = "localhost:9001")
public interface MicroserviceLocalEmergencyScheduler {

    @GetMapping(name = "/local_schedueling")
    String getThis();

    @PostMapping(name = "/local_scheduel")
    void LocalScheduling(@RequestBody PatientScheduelingForm patientScheduelingForm);
}
