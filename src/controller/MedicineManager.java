package com.abuelitaalert.controller;

import com.abuelitaalert.model.Medicine;
import com.abuelitaalert.persistence.MedicineFile;
import java.util.List;

public class MedicineManager {
    private MedicineFile file = new MedicineFile();

    public void addMedicine(Medicine m) {
        file.saveMedicine(m);
    }

    public List<Medicine> getAll() {
        return file.loadMedicines();
    }
}