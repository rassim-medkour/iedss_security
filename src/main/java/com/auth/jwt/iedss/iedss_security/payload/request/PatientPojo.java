package com.auth.jwt.iedss.iedss_security.payload.request;

import com.auth.jwt.iedss.iedss_security.models.PatientScheduelingForm;

public class PatientPojo {
    private PatientScheduelingForm patientScheduelingForm;

    public PatientScheduelingForm getPatientScheduelingForm() {
        return patientScheduelingForm;
    }

    public void setPatientScheduelingForm(PatientScheduelingForm patientScheduelingForm) {
        this.patientScheduelingForm = patientScheduelingForm;
    }
}
