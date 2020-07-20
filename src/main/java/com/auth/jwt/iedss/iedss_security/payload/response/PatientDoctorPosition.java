package com.auth.jwt.iedss.iedss_security.payload.response;

public class PatientDoctorPosition {
    String doctorName;
    int position;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
