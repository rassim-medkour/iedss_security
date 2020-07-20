package com.auth.jwt.iedss.iedss_security.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

public class PatientScheduelingForm {
    @NotBlank
    private String patientName;
    @NotBlank
    private int sevirityIndex;
    @NotBlank
    private int injurityLevel;
    private Timestamp entranceTime;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getSevirityIndex() {
        return sevirityIndex;
    }

    public void setSevirityIndex(int sevirityIndex) {
        this.sevirityIndex = sevirityIndex;
    }

    public int getInjurityLevel() {
        return injurityLevel;
    }

    public void setInjurityLevel(int injurityLevel) {
        this.injurityLevel = injurityLevel;
    }

    public Timestamp getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Timestamp entranceTime) {
        this.entranceTime = entranceTime;
    }
    @Override
    public String toString() {
        return "PatientScheduelingForm{" +
                "patientName='" + patientName + '\'' +
                ", sevirityIndex=" + sevirityIndex +
                ", injurityLevel=" + injurityLevel +
                ", entranceTime=" + entranceTime +
                '}';
    }


}
