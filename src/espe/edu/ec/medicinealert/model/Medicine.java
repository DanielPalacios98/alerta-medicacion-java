package espe.edu.ec.medicinealert.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Medicine {
    private String name;
    private String dose;
    private LocalTime[] reminderTimes;

    // Constructor, getters y métodos...

    public boolean shouldTakeNow(LocalTime now) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}