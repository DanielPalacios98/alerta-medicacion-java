package espe.edu.ec.medicinealert.model;

import java.time.LocalTime;

public class Medicine {
    private String name;
    private LocalTime time;

    public Medicine(String name, LocalTime time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }
}
