package com.abuelitaalert.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Medicine implements Serializable {
    private String name;
    private String dose;
    private LocalTime time;

    public Medicine(String name, String dose, LocalTime time) {
        this.name = name;
        this.dose = dose;
        this.time = time;
    }

    public String getName() { return name; }
    public String getDose() { return dose; }
    public LocalTime getTime() { return time; }

    public boolean isTimeToTake() {
        return LocalTime.now().withSecond(0).equals(time.withSecond(0));
    }

    @Override
    public String toString() {
        return name + " - " + dose + " - " + time;
    }
}