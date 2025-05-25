package com.abuelitaalert.view;

import com.abuelitaalert.controller.*;
import com.abuelitaalert.model.*;
import java.time.LocalTime;
import java.util.Scanner;

public class MainMenu {
    public void start() {
        Scanner sc = new Scanner(System.in);
        PatientManager patientManager = new PatientManager();
        MedicineManager medicineManager = new MedicineManager();
        AlarmManager alarmManager = new AlarmManager();

        System.out.println("Register a patient:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        Patient p = new Patient(name, age);
        patientManager.addPatient(p);

        System.out.println("Add a medicine:");
        System.out.print("Name: ");
        String med = sc.nextLine();
        System.out.print("Dose: ");
        String dose = sc.nextLine();
        System.out.print("Time (HH:mm): ");
        String timeStr = sc.nextLine();
        LocalTime time = LocalTime.parse(timeStr);
        Medicine medicine = new Medicine(med, dose, time);
        medicineManager.addMedicine(medicine);

        alarmManager.scheduleAlarms(medicineManager.getAll());

        System.out.println("System running... Press Ctrl+C to stop.");
    }
}