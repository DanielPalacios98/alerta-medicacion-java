package espe.edu.ec.medicinealert.core;

import espe.edu.ec.medicinealert.model.Medicine;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AlertSystem {
    private static ScheduledExecutorService scheduler;

    public static void start(List<Medicine> medicines) {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> checkMedicationTime(medicines), 0, 1, TimeUnit.MINUTES);
    }

    private static void checkMedicationTime(List<Medicine> medicines) {
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        for (Medicine med : medicines) {
            if (now.equals(med.getTime())) {
                showAlert(med);
            }
        }
    }

    private static void showAlert(Medicine medicine) {
        System.out.println("¡Es hora de tomar el medicamento: " + medicine.getName() + "!");
    }

    public static void stop() {
        scheduler.shutdown();
    }
}
