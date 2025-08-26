package com.planifylab;

public class ScheduleEntry {
String sampleId;
String technicianId;
String equipmentId;
String startTime;
String endTime;
String priority;

public ScheduleEntry(String sampleId, String technicianId, String equipmentId,
                     String startTime, String endTime, String priority) {
    this.sampleId = sampleId;
    this.technicianId = technicianId;
    this.equipmentId = equipmentId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.priority = priority;
}

@Override
public String toString() {
    return String.format("Sample %s -> Tech %s, Equip %s [%s - %s] (%s)",
            sampleId, technicianId, equipmentId, startTime, endTime, priority);
}
}