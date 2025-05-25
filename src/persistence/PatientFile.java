package com.abuelitaalert.persistence;

import com.abuelitaalert.model.Patient;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatientFile {
    private final String FILE_NAME = "patients.dat";

    public void savePatient(Patient p) {
        List<Patient> list = loadPatients();
        list.add(p);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> loadPatients() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Patient>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}