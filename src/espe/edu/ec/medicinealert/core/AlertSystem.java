package espe.edu.ec.medicinealert.core;

import espe.edu.ec.medicinealert.model.Medicine;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.*;

public class AlertSystem {
    private static final ScheduledExecutorService scheduler = 
        Executors.newScheduledThreadPool(1);

    public static void start() {
        scheduler.scheduleAtFixedRate(() -> {
            checkMedicationTime();
        }, 0, 1, TimeUnit.MINUTES);
    }

    private static void checkMedicationTime() {
        List<Medicine> medicines = FileManager.loadMedicines();
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        
        medicines.forEach(medicine -> {
            if (medicine.shouldTakeNow(now)) {
                showAlert(medicine);
            }
        });
    }

    private static void showAlert(Medicine medicine) {
        String message = String.format(
            "ALERT: Take %s (Dose: %s)",
            medicine.getName(),
            medicine.getDose()
        );
        System.out.println(message);
        // Opcional: Notificación visual con JOptionPane
    }

    public static void stop() {
        scheduler.shutdown();
    }
}

