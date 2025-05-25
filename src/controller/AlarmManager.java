package com.abuelitaalert.controller;

import com.abuelitaalert.model.Medicine;
import java.util.List;
import java.util.concurrent.*;

public class AlarmManager {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Alarm alarm = new Alarm();

    public void scheduleAlarms(List<Medicine> meds) {
        scheduler.scheduleAtFixedRate(() -> {
            for (Medicine m : meds) {
                if (m.isTimeToTake()) {
                    alarm.activate("Time to take: " + m.getName());
                }
            }
        }, 0, 1, TimeUnit.MINUTES);
    }
}