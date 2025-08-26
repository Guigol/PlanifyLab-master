package com.planifylab;

public class Technician {
    public String id;
    public String name;
    public String speciality; // BLOOD, URINE, TISSUE, GENERAL
    public String startTime;
    public String endTime;

    public Technician(String id, String name, String speciality, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
