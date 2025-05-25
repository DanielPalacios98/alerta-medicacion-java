package com.abuelitaalert.persistence;

import com.abuelitaalert.model.Medicine;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineFile {
    private final String FILE_NAME = "medicines.dat";

    public void saveMedicine(Medicine m) {
        List<Medicine> list = loadMedicines();
        list.add(m);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Medicine> loadMedicines() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Medicine>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}