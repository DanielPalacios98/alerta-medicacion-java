package espe.edu.ec.medicinealert.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase de utilidad para manejo de tiempos y formatos.
 */
public class TimeUtils {

    // Formato de hora estándar (ej: "14:30")
    private static final DateTimeFormatter TIME_FORMATTER = 
        DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Convierte un String en formato "HH:mm" a LocalTime.
     */
    public static LocalTime parseTime(String timeStr) throws DateTimeParseException {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    /**
     * Formatea una LocalTime a String en formato "hh:mm a" (ej: "02:30 PM").
     */
    public static String formatTo12Hours(LocalTime time) {
        return time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    /**
     * Verifica si una hora está dentro de un rango (inclusive).
     */
    public static boolean isTimeInRange(LocalTime time, LocalTime start, LocalTime end) {
        return !time.isBefore(start) && !time.isAfter(end);
    }

    /**
     * Obtiene la hora actual truncada a minutos.
     */
    public static LocalTime getCurrentTimeTruncated() {
        return LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
    }
}