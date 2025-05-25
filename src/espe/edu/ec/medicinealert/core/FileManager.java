package espe.edu.ec.medicinealert.core;

import espe.edu.ec.medicinealert.model.Medicine;  // Import corregido
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String MEDICINE_FILE = System.getProperty("user.dir") + "/data/medicines.dat"; 
    public static List<Medicine> loadMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(MEDICINE_FILE))) {
            
            while (true) {
                Medicine med = (Medicine) ois.readObject();
                medicines.add(med);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (Exception e) {
            System.err.println("Error loading medicines: " + e.getMessage());
        }
        return medicines;
    }
    
    public static void saveMedicines(List<Medicine> medicines) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(MEDICINE_FILE))) {
            
            for (Medicine med : medicines) {
                oos.writeObject(med);
            }
        } catch (Exception e) {
            System.err.println("Error saving medicines: " + e.getMessage());
        }
    }
}