package espe.edu.ec.medicinealert.core;

import espe.edu.ec.medicinealert.model.Medicine;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.*;

public class AlertSystem {
    private static final ScheduledExecutorService scheduler = 
        Executors.newScheduledThreadPool(1);

    // Método para iniciar el sistema de alertas
    public static void start() {
        scheduler.scheduleAtFixedRate(() -> {
            checkMedicationTime();
        }, 0, 1, TimeUnit.MINUTES);  // Verifica cada minuto
    }

    // Verifica si es hora de tomar medicación
    private static void checkMedicationTime() {
        List<Medicine> medicines = FileManager.loadMedicines();
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        
        for (Medicine medicine : medicines) {
            if (medicine.shouldTakeNow(now)) {
                showAlert(medicine);  // Llama al método corregido
            }
        }
    }

private static void showAlert(Medicine medicine) {
    String message = String.format(
        "⚠️ ALERTA: Es hora de tomar %s (Dosis: %s) ⚠️",
        medicine.getName(),  // Asegúrate de que coincida con el getter
        medicine.getDose()   // en Medicine.java
    );
    System.out.println(message);
}  // Notificación en consola
        
        // Opcional: Notificación visual (requiere javax.swing)
        // javax.swing.JOptionPane.showMessageDialog(null, message);
    }

    // Detiene el sistema de alertas
    public static void stop() {
        scheduler.shutdown();
    }
}