package com.planifylab;

public class Sample {
    public String id;
    public String type;       // BLOOD, URINE, TISSUE
    public String priority;   // STAT, URGENT, ROUTINE
    public int analysisTime;  // en minutes
    public String arrivalTime;
    public String patientId;

    public Sample(String id, String type, String priority, int analysisTime, String arrivalTime, String patientId) {
        this.id = id;
        this.type = type;
        this.priority = priority;
        this.analysisTime = analysisTime;
        this.arrivalTime = arrivalTime;
        this.patientId = patientId;
    }
}
