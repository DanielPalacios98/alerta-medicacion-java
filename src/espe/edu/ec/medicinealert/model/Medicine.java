package espe.edu.ec.medicinealert.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;  // ¡Import añadido aquí!

public class Medicine {
    private String name;
    private String dose;
    private LocalTime[] reminderTimes;

    // Constructor
    public Medicine(String name, String dose, LocalTime[] reminderTimes) {
        this.name = name;
        this.dose = dose;
        this.reminderTimes = reminderTimes;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDose() {
        return dose;
    }

    public LocalTime[] getReminderTimes() {
        return reminderTimes;
    }

    // Método para verificar si es hora de la medicación
    public boolean shouldTakeNow(LocalTime currentTime) {
        for (LocalTime time : reminderTimes) {
            if (time.truncatedTo(ChronoUnit.MINUTES)  // Usa ChronoUnit
                    .equals(currentTime.truncatedTo(ChronoUnit.MINUTES))) {
                return true;
            }
        }
        return false;
    }
}