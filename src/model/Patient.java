package com.abuelitaalert.model;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient: " + name + ", Age: " + age;
    }
}