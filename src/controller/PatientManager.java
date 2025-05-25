package com.abuelitaalert.controller;

import com.abuelitaalert.model.Patient;
import com.abuelitaalert.persistence.PatientFile;
import java.util.List;

public class PatientManager {
    private PatientFile file = new PatientFile();

    public void addPatient(Patient p) {
        file.savePatient(p);
    }

    public List<Patient> getAll() {
        return file.loadPatients();
    }
}