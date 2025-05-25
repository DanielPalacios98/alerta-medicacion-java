package espe.edu.ec.medicinealert.core;

import espe.edu.ec.medicinealert.model.Medicine;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Medicine> medicines = new ArrayList<>();
        medicines.add(new Medicine("Paracetamol", LocalTime.now().plusMinutes(1).truncatedTo(java.time.temporal.ChronoUnit.MINUTES)));
        medicines.add(new Medicine("Ibuprofeno", LocalTime.now().plusMinutes(2).truncatedTo(java.time.temporal.ChronoUnit.MINUTES)));

        AlertSystem.start(medicines);
    }
}
